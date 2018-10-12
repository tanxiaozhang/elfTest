package com.wux.rcb.elf.biz.service;

import com.wux.rcb.elf.biz.model.vo.ExchangeRatePrice;

import java.util.List;

public interface IExchangeRateService {
    void saveExchangeRatePrices(List<ExchangeRatePrice> exchangeRatePrices);

    List<ExchangeRatePrice> getExchangeRatePrices();
}
