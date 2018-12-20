package com.wux.rcb.elf.biz.model.vo;

import com.wux.rcb.elf.biz.model.DataConvertRuleDetailDo;

import java.util.List;

/**
 * 数据转换规则展示对象
 * */
public class DataConvertRule extends BaseVO {

    private Long id;

    private String ruleName;

    private String tableName;

    private List<DataConvertRuleDetailDo> dataConvertRuleDetailDoList;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DataConvertRuleDetailDo> getDataConvertRuleDetailDoList() {
        return dataConvertRuleDetailDoList;
    }

    public void setDataConvertRuleDetailDoList(List<DataConvertRuleDetailDo> dataConvertRuleDetailDoList) {
        this.dataConvertRuleDetailDoList = dataConvertRuleDetailDoList;
    }
}
