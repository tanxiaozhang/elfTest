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
        int columnsNum = sheet.getRow(0).getPhysicalNumberOfCells();
        int recordCount = 1;
        String salaryType = inputFileName.split("-")[0];
        FileOutputStream outStream = null;
        try{
            File outputFile = new File(outputFilePath + "\\" + outputFileName);
            outStream = new FileOutputStream(outputFile);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                DataOption dataOption;
                String[] record = new String[6];
                String recordString = "";
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
                    if (j == 1 || j == 2) {
                        record[j] = dataOption.getValue().toString();
                    }
                    //金额列强制读取文本格式数据避免产生精度误差
                    if (j == 3 || j == 4) {
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        record[j] = row.getCell(j).getStringCellValue();
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
                }
                if("02".equals(salaryType) || "03".equals(salaryType)){
                    record[2] = "";
                }
                recordString = StringUtils.join(record, ",");
                if("03".equals(salaryType)){
                    recordString = recordString.replaceAll(",,",",");
                }
                recordString += ",\r\n";
                //文件输出流用于将数据写入文件
                outStream.write(recordString.getBytes());
                recordCount++;
            }
        }catch (Exception e){
            logger.error("convertSalary error {}",e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("End convert salary file {}", inputFileName);
    }
}
