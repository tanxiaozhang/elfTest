package com.wux.rcb.elf.biz.dao;

import com.wux.rcb.elf.biz.model.DataConvertRuleDetailDo;

import java.util.List;

public interface DataConvertRuleDetailDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataConvertRuleDetailDo record);

    int insertSelective(DataConvertRuleDetailDo record);

    DataConvertRuleDetailDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataConvertRuleDetailDo record);

    int updateByPrimaryKey(DataConvertRuleDetailDo record);

    List<DataConvertRuleDetailDo> getDetailsByRuleId(Long ruleId);
}