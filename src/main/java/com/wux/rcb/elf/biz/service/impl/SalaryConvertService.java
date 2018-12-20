package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.model.DataOption;
import com.wux.rcb.elf.biz.service.ISalaryConvertService;
import com.wux.rcb.elf.util.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
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
                for(int j = 0; j < row.getPhysicalNumberOfCells(); j ++){
                    dataOption = ExcelUtil.getCellFormatValue(row.getCell(j));
                    //对于不是序号开始的记录进行过滤
                    if (j == 0 && (StringUtils.isBlank(dataOption.getValue().toString()) ||
                            "Numeric".equals(dataOption.getDbtype()) == false)) {
                        break;
                    }
                    //填充数据
                    if(j >0){
                        record[j] = dataOption.getValue().toString();
                    }
                }
                for (int k = 0; k < 8 - String.valueOf(recordCount).length(); k++) {
                    record[0] = "0" + recordCount;
                }
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
                recordString += ",";
                //文件输出流用于将数据写入文件
                outStream.write(recordString.getBytes());
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

    }
}
