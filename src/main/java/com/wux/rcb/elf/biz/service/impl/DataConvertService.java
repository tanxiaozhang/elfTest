package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.DataConvertRuleDetailDoMapper;
import com.wux.rcb.elf.biz.dao.DataConvertRuleDoMapper;
import com.wux.rcb.elf.biz.model.DataConvertRuleDetailDo;
import com.wux.rcb.elf.biz.model.DataConvertRuleDo;
import com.wux.rcb.elf.biz.model.DataOption;
import com.wux.rcb.elf.biz.model.vo.DataConvertRule;
import com.wux.rcb.elf.biz.service.IDataConvertService;
import com.wux.rcb.elf.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.util.*;

@Service
public class DataConvertService implements IDataConvertService {

    private Logger logger = LoggerFactory.getLogger(DataConvertService.class);

    @Autowired
    private DataConvertRuleDoMapper dataConvertRuleDoMapper;

    @Autowired
    private DataConvertRuleDetailDoMapper dataConvertRuleDetailDoMapper;

    @Override
    public List<DataConvertRule> getAllDataConvertRules() {
        List<DataConvertRuleDo> dataConvertRuleDoList = dataConvertRuleDoMapper.selectByCondition(new DataConvertRuleDo());
        List<DataConvertRule> dataConvertRuleList = new ArrayList();
        for (DataConvertRuleDo dataConvertRuleDo : dataConvertRuleDoList) {
            DataConvertRule dataConvertRule = new DataConvertRule();
            BeanUtils.copyProperties(dataConvertRuleDo, dataConvertRule);
            List<DataConvertRuleDetailDo> dataConvertRuleDetailDoList = dataConvertRuleDetailDoMapper.getDetailsByRuleId(dataConvertRuleDo.getId());
            if (!CollectionUtils.isEmpty(dataConvertRuleDetailDoList)) {
                dataConvertRule.setDataConvertRuleDetailDoList(dataConvertRuleDetailDoList);
            }
            dataConvertRuleList.add(dataConvertRule);
        }
        return dataConvertRuleList;
    }

    @Override
    @Transactional
    public void importExcelData(MultipartFile file, Long id) {
        logger.info("Start import excel {}, ruleId {}", file.getOriginalFilename(), id);
        Workbook wb;
        boolean isOffice2003 = false;
        DataConvertRuleDo dataConvertRuleDo =  dataConvertRuleDoMapper.selectByPrimaryKey(id);
        List<DataConvertRuleDetailDo> dataConvertRuleDetailDoList = dataConvertRuleDetailDoMapper.getDetailsByRuleId(id);
        if(CollectionUtils.isEmpty(dataConvertRuleDetailDoList)){
            logger.error("");
        }
        String[] columns = null;
        try {
            if(file.getOriginalFilename().endsWith("xls")){
                isOffice2003 = true;
            }
            if(isOffice2003){
                wb = new HSSFWorkbook(file.getInputStream());
            }
            else {
                wb =  new XSSFWorkbook(file.getInputStream());
            }
            //默认只解析第一张表
            Sheet sheet = wb.getSheetAt(0);
            logger.debug("sheet name = " + wb.getSheetName(0));
            //默认从第一行开始解析，默认最多
            int columnsNum = sheet.getRow(0).getPhysicalNumberOfCells();
            columns = new String[columnsNum];
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                DataOption dataOption ;
                List<DataOption> dataList = new ArrayList<>();
                for(int j = 0; j < row.getPhysicalNumberOfCells(); j ++){
                    if(isOffice2003){
                        HSSFCell cell = (HSSFCell) row.getCell(j);
                        dataOption = ExcelUtil.getCellFormatValue(cell);
                    }else {
                        XSSFCell cell = (XSSFCell) row.getCell(j);
                        dataOption = ExcelUtil.getCellFormatValue(cell);
                    }
                    //业务数据封装,中文列名映射英文
                    if(i == 0){
                        for(DataConvertRuleDetailDo dataConvertRuleDetailDo : dataConvertRuleDetailDoList){
                            if(StringUtils.equals(dataConvertRuleDetailDo.getBizFieldName(), dataOption.getValue().toString())){
                                columns[j] = dataConvertRuleDetailDo.getDbFieldName();
                                break;
                            }
                        }
                        if(StringUtils.isEmpty(columns[j])){
                            logger.warn("Cannot find rule detail for column {}", dataOption.getValue().toString());
                        }
                    }else{
                        dataOption.setName(columns[j]);
                    }
                    if(i > 0){
                        dataList.add(dataOption);
                    }
                }
                if (i > 0) {
                    this.saveData(dataList, dataConvertRuleDo.getTableName());
                }
            }

        } catch (Exception e) {
            logger.error("Import excel file error ! fileName is {} ,error msg {}", file.getOriginalFilename(), e.getMessage());
        }
    }

    private void saveData(List<DataOption> dataList, String tableName) {
        dataConvertRuleDetailDoMapper.saveData(dataList, tableName);
    }
}
