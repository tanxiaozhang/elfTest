package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.constant.CurrencyCodeEnum;
import com.wux.rcb.elf.biz.model.vo.ExchangeRatePrice;
import com.wux.rcb.elf.biz.service.IExchangeRateService;
import com.wux.rcb.elf.util.RedisOpsUtil;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 外汇牌价服务
 * */
@Service
public class ExchangeRateServiceImpl implements IExchangeRateService {

    @Autowired
    private RedisOpsUtil redisOpsUtil;

    private static final String exchangeRatePriceKey = "exchangeRatePrice";

    @Override
    public void saveExchangeRatePrices(List<ExchangeRatePrice> exchangeRatePrices) {
        exchangeRatePrices.forEach(e -> {
            e.setCurrencyCName(EnumUtils.getEnum(CurrencyCodeEnum.class, e.getCurrency().toUpperCase()).getCurrencyCName());
        });
        redisOpsUtil.saveObject(exchangeRatePriceKey, exchangeRatePrices);
    }

    @Override
    public List<ExchangeRatePrice> getExchangeRatePrices() {
       return redisOpsUtil.getArray(exchangeRatePriceKey, ExchangeRatePrice.class);
    }
}
