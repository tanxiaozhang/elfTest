package com.wux.rcb.elf.util;

import java.io.FileInputStream;
import java.io.InputStream;

import com.wux.rcb.elf.biz.model.DataOption;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * EXCEL相关的处理类
 * */
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (Exception e) {
            logger.error("Read excel error!");
        }
        return wb;
    }

    public static boolean checkExcelFileName(String fileName) {
        if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
            return true;
        }
        return false;
    }

    public static boolean isOffice2003(String fileName){
        if(!StringUtils.isEmpty(fileName) && fileName.endsWith("xls")){
            return true;
        }
        return false;
    }

    public static Workbook loadExcel(String fileName, InputStream fileStream){
        Workbook wb = null;
        try {
            if (isOffice2003(fileName)) {
                wb = new HSSFWorkbook(fileStream);
            } else {
                wb = new XSSFWorkbook(fileStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static DataOption getCellFormatValue(Cell cell){
        DataOption dataOption = new DataOption();
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    dataOption.setValue(String.valueOf(cell.getNumericCellValue()));
                    dataOption.setDbtype("Numeric");
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if( org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        dataOption.setValue(cell.getDateCellValue());
                        dataOption.setDbtype("Date");
                    }else{
                        //数字
                        dataOption.setValue(String.valueOf(cell.getNumericCellValue()));
                        dataOption.setDbtype("Numeric");
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    dataOption.setValue(cell.getRichStringCellValue().getString());
                    dataOption.setDbtype("String");
                    break;
                }
                default:
                    dataOption.setValue("");
                    dataOption.setDbtype("String");
            }
        }else{
            dataOption.setValue("");
            dataOption.setDbtype("String");
        }
        return dataOption;
    }

}
