package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.DataConvertRuleDetailDoMapper;
import com.wux.rcb.elf.biz.dao.DataConvertRuleDoMapper;
import com.wux.rcb.elf.biz.model.DataConvertRuleDetailDo;
import com.wux.rcb.elf.biz.model.DataConvertRuleDo;
import com.wux.rcb.elf.biz.model.DataOption;
import com.wux.rcb.elf.biz.model.vo.DataConvertRule;
import com.wux.rcb.elf.biz.model.vo.DataConvertRuleDetail;
import com.wux.rcb.elf.biz.service.IDataConvertService;
import com.wux.rcb.elf.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
        DataConvertRuleDo dataConvertRuleDo =  dataConvertRuleDoMapper.selectByPrimaryKey(id);
        List<DataConvertRuleDetailDo> dataConvertRuleDetailDoList = dataConvertRuleDetailDoMapper.getDetailsByRuleId(id);
        if(CollectionUtils.isEmpty(dataConvertRuleDetailDoList)){
            logger.error("No details found in this rule , rule id {}", id);
            return;
        }
        try {
            Workbook wb = ExcelUtil.loadExcel(file.getOriginalFilename(), file.getInputStream());
            //默认只解析第一张表
            Sheet sheet = wb.getSheetAt(0);
            //默认从第一行开始解析
            int columnsNum = sheet.getRow(0).getPhysicalNumberOfCells();
            String[] columns = new String[columnsNum];
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                DataOption dataOption ;
                List<DataOption> dataList = new ArrayList<>();
                for(int j = 0; j < row.getPhysicalNumberOfCells(); j ++){
                    dataOption = ExcelUtil.getCellFormatValue(row.getCell(j));
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

    @Override
    public List<DataConvertRuleDetail> findRuleDetails(Long ruleId) {
        List<DataConvertRuleDetailDo> dataConvertRuleDetailDoList = dataConvertRuleDetailDoMapper.getDetailsByRuleId(ruleId);
        List<DataConvertRuleDetail> dataConvertRuleDetailList = new ArrayList<>();
        dataConvertRuleDetailDoList.forEach(e->{
            DataConvertRuleDetail dataConvertRuleDetail = new DataConvertRuleDetail();
            BeanUtils.copyProperties(e, dataConvertRuleDetail);
            dataConvertRuleDetailList.add(dataConvertRuleDetail);
        });
        return dataConvertRuleDetailList;
    }

    @Override
    public void importRuleDetails(MultipartFile file, Long ruleId) {
        logger.info("Start import rule detail {}, ruleId {}", file.getOriginalFilename(), ruleId);
        try{
            Workbook wb = ExcelUtil.loadExcel(file.getOriginalFilename(), file.getInputStream());
            //默认只解析第一张表
            Sheet sheet = wb.getSheetAt(0);
            //默认从第二行开始解析内容，格式为:业务字段，表字段
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                DataConvertRuleDetailDo dataConvertRuleDetailDo = new DataConvertRuleDetailDo();
                Row row = sheet.getRow(i);
                DataOption dataOption;
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    dataOption = ExcelUtil.getCellFormatValue(row.getCell(j));
                    if(j == 0){
                        dataConvertRuleDetailDo.setBizFieldName(dataOption.getValue().toString());
                    }
                    if(j == 1){
                        dataConvertRuleDetailDo.setDbFieldName(dataOption.getValue().toString());
                    }
                }
                dataConvertRuleDetailDo.setCreateTime(new Date());
                dataConvertRuleDetailDo.setCreator("System");
                dataConvertRuleDetailDo.setRuleId(ruleId);
                dataConvertRuleDetailDoMapper.insertSelective(dataConvertRuleDetailDo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saveData(List<DataOption> dataList, String tableName) {
        dataConvertRuleDetailDoMapper.saveData(dataList, tableName);
    }
}
