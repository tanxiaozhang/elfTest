package com.wux.rcb.elf.biz.model;

import java.util.Date;

public class DataConvertRuleDetailDo {
    private Long id;

    private Long ruleId;

    private String bizFieldName;

    private String dbFieldName;

    private String fieldValue;

    private Date createTime;

    private Date modifyTime;

    private String creator;

    private String modifier;

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

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue == null ? null : fieldValue.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }
}