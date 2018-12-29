package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.model.DataOption;
import com.wux.rcb.elf.biz.service.ISalaryConvertService;
import com.wux.rcb.elf.util.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * 工资代发文件转换实现类
 * 文件名进行区分，01-xxx银行卡代发, 02-xxx身份证代发, 03-xxx身份证开卡
 * xxx表示代发机构号
 * */
@Service
public class SalaryConvertService implements ISalaryConvertService {

    private Logger logger = LoggerFactory.getLogger(SalaryConvertService.class);

    @Override
    public void convertSalary(String inputFilePath, String inputFileName, String outputFilePath, String outputFileName) {
        logger.info("Start convert salary file {}", inputFileName);
        Workbook wb = ExcelUtil.readExcel(inputFilePath + "\\" + inputFileName);
        Sheet sheet = wb.getSheetAt(0);
        if(sheet.getNumMergedRegions()>0){
            logger.error("Merged regions Exist! Stop!");
            return;
        }
        int recordCount = 1;
        BigDecimal sumAmount = new BigDecimal(0);
        List<String> dataList = new ArrayList<>();
        String salaryType = inputFileName.split("-")[0];
        FileOutputStream outStream = null;
        try{
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                DataOption dataOption;
                String[] record = new String[6];
                boolean recordFlag = true;
                for(int j = 0; j < 5; j ++){
                    dataOption = ExcelUtil.getCellFormatValue(row.getCell(j));
                    //对于不是序号开始的记录进行过滤
                    if (j == 0 && (StringUtils.isBlank(dataOption.getValue().toString()) ||
                            "Numeric".equals(dataOption.getDbtype()) == false)) {
                        recordFlag =  false;
                        break;
                    }
                    //填充数据
                    if (j == 1) {
                        record[j] = dataOption.getValue().toString();
                    }
                    //金额列强制读取文本格式数据避免产生精度误差
                    if (row.getCell(j) != null && (j == 2 || j == 3 || j == 4)) {
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        record[j] = row.getCell(j).getStringCellValue().trim();
                    }

                    //金额保留两位小数
                    if(j == 3){
                        record[j] = new BigDecimal(record[j]).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                    }
                }
                if(recordFlag == false){
                    continue;
                }
                record[0] = String.valueOf(recordCount);
                for (int k = 0; k < 8 - String.valueOf(recordCount).length(); k++) {
                    record[0] = "0" + record[0];
                }
                //调整身份证号码位置，并设置身份证类型
                record[5] = record[4];
                record[4] = "101";
                //序号自动补充0到8位数
                if("01".equals(salaryType)){
                    record[5] = "";
                    if(this.isAccountNumber(record[2]) == false){
                        logger.error("Customer {} has a error accountNo {}! Stop!", record[1], record[2]);
                        return;
                    }
                }
                if("02".equals(salaryType) || "03".equals(salaryType)){
                    record[2] = "";
                    if(this.isIDNumber(record[5]) == false){
                        logger.error("Customer {} has a error id {}! Stop!", record[1], record[5]);
                        return;
                    }
                }
                String recordString = StringUtils.join(record, ",");
                if("03".equals(salaryType)){
                    recordString = recordString.replaceAll(",,",",");
                }
                if(i < sheet.getLastRowNum()){
                    recordString += ",\r\n";
                }
                dataList.add(recordString);
                recordCount++;
                sumAmount = sumAmount.add(new BigDecimal(record[3]));
            }
            //文件输出流用于将数据写入文件
            File outputFile = new File(outputFilePath + "\\" + outputFileName);
            outStream = new FileOutputStream(outputFile);
            for (String recordString : dataList) {
                outStream.write(recordString.getBytes());
            }
        }catch (Exception e){
            logger.error("convertSalary error {}",e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if(outStream != null){
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("End convert salary file! All {} customers and amount sum is {} ", recordCount-1, sumAmount.toString());
    }

    private boolean isAccountNumber(String account) {
        boolean isAccountNumber = false;
        if(StringUtils.isBlank(account)){
            return false;
        }
        if(account.startsWith("6") && account.length() == 19){
            isAccountNumber = true;
        }
        if(account.startsWith("1") && (account.length() == 15 || account.length() ==22)){
            isAccountNumber = true;
        }
        return isAccountNumber;
    }

    private boolean isIDNumber(String IDNumber) {
        if (StringUtils.isBlank(IDNumber)) {
            return false;
        }
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = IDNumber.matches(regularExpression);
        if (matches) {
            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() + "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常:" + IDNumber);
                    return false;
                }
            }
        }
        return matches;

    }

}
