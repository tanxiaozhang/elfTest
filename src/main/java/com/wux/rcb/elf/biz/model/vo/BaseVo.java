package com.wux.rcb.elf.biz.model.vo;

import com.wux.rcb.elf.util.DateUtil;
import org.springframework.util.StringUtils;

import java.util.Date;

public class BaseVo {
    //修改时间
    private Date modifyTime;

    //创建时间
    private Date createTime;

    //创建者
    private String creator;

    //修改者
    private String modifier;

    public void generateBaseInfo(Date modifyTime, Date createTime, String modifier, String creator) {
        if(createTime != null){
            this.createTime = createTime;
        }
        if(modifyTime != null){
            this.modifyTime = modifyTime;
        }
        if(!StringUtils.isEmpty(creator)){
            this.creator = creator;
        }
        if(!StringUtils.isEmpty(modifier)){
            this.modifier = modifier;
        }
    }

    public String getModifyTime() {
        return DateUtil.parseDateToStr(modifyTime, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
    }

    public String getCreateTime() {
        return DateUtil.parseDateToStr(createTime, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
