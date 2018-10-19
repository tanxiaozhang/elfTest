package com.wux.rcb.elf.biz.controller;

import com.wux.rcb.elf.biz.model.vo.ExchangeRatePrice;
import com.wux.rcb.elf.biz.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/estore")
public class ExchangeRateController {
    @Autowired
    private IExchangeRateService exchangeRateService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String one(Map<String, Object> map){
        map.put("title", "吴兴农商银行外汇牌价系统");
        List<ExchangeRatePrice> exchangeRatePriceList = exchangeRateService.getExchangeRatePrices();
        map.put("updateTime", exchangeRatePriceList.get(0).getModifyTime());
        map.put("priceList", exchangeRatePriceList);
        return "exchangeRatePrice";
    }

}
