package com.wux.rcb.elf.biz.model.vo;

import com.wux.rcb.elf.util.DateUtil;
import org.springframework.util.StringUtils;

import java.util.Date;

public class BaseVo {
    //修改时间
    private String modifyTime;

    //创建时间
    private String createTime;

    //创建者
    private String creator;

    //修改者
    private String modifyer;

    public void generateBaseInfo(Date modifyTime, Date createTime, String modifyer, String creator) {
        if(createTime != null){
            this.createTime = DateUtil.parseDateToStr(createTime, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        }
        if(modifyTime != null){
            this.modifyTime = DateUtil.parseDateToStr(modifyTime, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        }
        if(!StringUtils.isEmpty(creator)){
            this.creator = creator;
        }
        if(!StringUtils.isEmpty(modifyer)){
            this.modifyer = modifyer;
        }
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer;
    }
}
