package com.wux.rcb.elf.biz.constant;

/**
 * 币种枚举类
 * */
public enum CurrencyCodeEnum {
    CNY("CNY", "人民币"),
    USD("USD", "美元"),
    HKD("HKD", "港元"),
    EUR("EUR", "欧元"),
    JPY("JPY", "日元"),
    GBP("GBP", "英镑"),
    CHF("CHF", "瑞士法郎"),
    CAD("CAD", "加元"),
    AUD("AUD", "澳元"),
    SGD("SGD", "新加坡元"),
    MYR("MYR", "马来西亚币"),
    VND("VND", "越南币"),
    THB("THB", "泰铢"),
    ;

    private String code;

    private String currencyCName;

    CurrencyCodeEnum(String code, String currencyCName){
        this.code = code;
        this.currencyCName = currencyCName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrencyCName() {
        return currencyCName;
    }

    public void setCurrencyCName(String currencyCName) {
        this.currencyCName = currencyCName;
    }
}
