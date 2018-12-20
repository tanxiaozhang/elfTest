package com.wux.rcb.elf.biz.model.vo;

public class DataConvertRuleDetail extends BaseVO {
    private Long id;

    private Long ruleId;

    private String bizFieldName;

    private String dbFieldName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getBizFieldName() {
        return bizFieldName;
    }

    public void setBizFieldName(String bizFieldName) {
        this.bizFieldName = bizFieldName == null ? null : bizFieldName.trim();
    }

    public String getDbFieldName() {
        return dbFieldName;
    }

    public void setDbFieldName(String dbFieldName) {
        this.dbFieldName = dbFieldName == null ? null : dbFieldName.trim();
    }
}