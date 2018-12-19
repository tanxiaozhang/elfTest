package com.wux.rcb.elf.biz.model;

import java.util.Date;

public class FtpDataImportDO {
    private Long id;

    private String acctType;

    private String accountNo;

    private String primCstId;

    private String rprgOuIpId;

    private String managerId;

    private Double paiRate;

    private Date strDate;

    private Date endDate;

    private String importMode;

    private String dealStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType == null ? null : acctType.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getPrimCstId() {
        return primCstId;
    }

    public void setPrimCstId(String primCstId) {
        this.primCstId = primCstId == null ? null : primCstId.trim();
    }

    public String getRprgOuIpId() {
        return rprgOuIpId;
    }

    public void setRprgOuIpId(String rprgOuIpId) {
        this.rprgOuIpId = rprgOuIpId == null ? null : rprgOuIpId.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public Double getPaiRate() {
        return paiRate;
    }

    public void setPaiRate(Double paiRate) {
        this.paiRate = paiRate;
    }

    public Date getStrDate() {
        return strDate;
    }

    public void setStrDate(Date strDate) {
        this.strDate = strDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImportMode() {
        return importMode;
    }

    public void setImportMode(String importMode) {
        this.importMode = importMode == null ? null : importMode.trim();
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus == null ? null : dealStatus.trim();
    }
}