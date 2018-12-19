package com.wux.rcb.elf.biz.model;

import java.util.Date;

/**
 * 信息系统存款明细对象
 * */
public class GlfmxcmxDO {

    /**账号*/
    String accountNo;

    /**客户内码*/
    String customerNo;

    /**客户经理号*/
    String customerManagerNo;

    /**账号所属机构号*/
    String orgNo;

    /**生效时间*/
    Date startDate;

    /**失效时间*/
    Date endDate;

    /**记录状态*/
    String status;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerManagerNo() {
        return customerManagerNo;
    }

    public void setCustomerManagerNo(String customerManagerNo) {
        this.customerManagerNo = customerManagerNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
