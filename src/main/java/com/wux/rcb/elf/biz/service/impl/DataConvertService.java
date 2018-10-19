package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.DataConvertRuleDetailDoMapper;
import com.wux.rcb.elf.biz.dao.DataConvertRuleDoMapper;
import com.wux.rcb.elf.biz.model.DataConvertRuleDetailDo;
import com.wux.rcb.elf.biz.model.DataConvertRuleDo;
import com.wux.rcb.elf.biz.model.vo.DataConvertRule;
import com.wux.rcb.elf.biz.service.IDataConvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
    public void importExcelData(MultipartFile file, Long id) {
        logger.info("Start import excel {}, ruleId {}", file.getOriginalFilename(), id);

    }
}
