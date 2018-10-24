package com.wux.rcb.elf.biz.dao;

import com.wux.rcb.elf.biz.model.DataConvertRuleDetailDo;
import com.wux.rcb.elf.biz.model.DataOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataConvertRuleDetailDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataConvertRuleDetailDo record);

    int insertSelective(DataConvertRuleDetailDo record);

    DataConvertRuleDetailDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataConvertRuleDetailDo record);

    int updateByPrimaryKey(DataConvertRuleDetailDo record);

    List<DataConvertRuleDetailDo> getDetailsByRuleId(Long ruleId);

    int saveData(@Param("list")List<DataOption> list, @Param("bizTableName")String bizTableName);
}