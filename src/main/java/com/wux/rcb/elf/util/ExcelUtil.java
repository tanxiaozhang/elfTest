package com.wux.rcb.elf.util;

import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc 简单封装一个自己使用的POI工具类
 * @Date 2019/04/22
 * @Author Tan
 * */
public class ExcelUtil {
    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static <T>HSSFWorkbook generateExcel(String[] title, String[] params, List<T> data) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");
        List<String[]> dataList = getValues(data, params);
        createSheet(workbook, sheet, title, dataList);
        String fileName = DateUtil.parseDateToStr(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD) + "export.xls";
        buildExcelFile(fileName, workbook);
        return workbook;
    }

    private static <T>List<String[]> getValues(List<T> data, String[] params) {
        List<String []> dataList = new ArrayList<>();
        for(Object obj : data){
            String[] values = new String[params.length];
            try {
                for(int i =0; i< params.length;i++){
                    Field field = obj.getClass().getDeclaredField(params[i]);
                    field.setAccessible(true);
                    values[i] = field.get(obj) == null?"":field.get(obj).toString();
                }
                dataList.add(values);
            }catch (Exception e){
                logger.error("Exception getValues in ExcelUtil", e);
            }
        }
        return dataList;
    }

    private static void createSheet(HSSFWorkbook workbook, HSSFSheet sheet, String[] title, List<String[]> dataList) {
        HSSFRow row = sheet.createRow(0);
        /**设置格式*/
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);

        /**设置标题和列宽*/
        for (int i = 0; i < title.length; i++) {
            HSSFCell cell;
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i)*16/10);
        }

        /**填充表格内容*/
        int rowNum = 1;
        for(String[] data: dataList){
            HSSFRow dataRow = sheet.createRow(rowNum);
            for(int i=0; i< data.length;i++){
                dataRow.createCell(i).setCellValue(data[i]);
            }
        }
    }

    //生成excel文件
    private static void buildExcelFile(String filename,HSSFWorkbook workbook){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
