package com.wux.rcb.elf.biz.model.vo;

/**
 * 外汇牌价对象
 * */
public class ExchangeRatePrice extends BaseVo {
    //币种
    private String currency;

    //币种中文
    private String currencyCName;

    //汇买价
    private String exchangePurchasePrice;

    //钞买价
    private String cashPurchasePrice;

    //卖出价
    private String salePrice;

    //中间价
    private String middlePrice;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchangePurchasePrice() {
        return exchangePurchasePrice;
    }

    public void setExchangePurchasePrice(String exchangePurchasePrice) {
        this.exchangePurchasePrice = exchangePurchasePrice;
    }

    public String getCashPurchasePrice() {
        return cashPurchasePrice;
    }

    public void setCashPurchasePrice(String cashPurchasePrice) {
        this.cashPurchasePrice = cashPurchasePrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getMiddlePrice() {
        return middlePrice;
    }

    public void setMiddlePrice(String middlePrice) {
        this.middlePrice = middlePrice;
    }

    public String getCurrencyCName() {
        return currencyCName;
    }

    public void setCurrencyCName(String currencyCName) {
        this.currencyCName = currencyCName;
    }
}
