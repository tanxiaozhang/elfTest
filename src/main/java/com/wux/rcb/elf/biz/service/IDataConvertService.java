package com.wux.rcb.elf.biz.service;

import com.wux.rcb.elf.biz.model.DataConvertRuleDo;
import com.wux.rcb.elf.biz.model.vo.DataConvertRule;
import com.wux.rcb.elf.biz.model.vo.DataConvertRuleDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDataConvertService {

    List<DataConvertRule> getAllDataConvertRules(DataConvertRuleDo dataConvertRuleDo);

    void importExcelData(MultipartFile file, Long id);

    List<DataConvertRuleDetail> findRuleDetails(Long ruleId);

    void importRuleDetails(MultipartFile file, Long ruleId);
}
