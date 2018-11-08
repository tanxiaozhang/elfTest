package com.wux.rcb.elf.biz.Task;

import com.wux.rcb.elf.biz.common.SocketClient;
import com.wux.rcb.elf.biz.model.vo.ExchangeRatePrice;
import com.wux.rcb.elf.biz.service.IExchangeRateService;
import com.wux.rcb.elf.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 外汇牌价定时任务
 * */
@Component
@EnableScheduling
public class ExchangeRateTask {

    private Logger logger = LoggerFactory.getLogger(ExchangeRateTask.class);
    @Autowired
    private IExchangeRateService exchangeRateService;

    private int taskTestExchangeRatePriceCount = 1;

    //@Scheduled(fixedRate = 5*60*1000)
    public void taskSyncExchangeRatePrice() {
        int taskSyncExchangeRatePriceCount =1;
        logger.info("start taskSyncExchangeRatePrice {} times", taskSyncExchangeRatePriceCount++);
        SocketClient socketClient = new SocketClient();
        String destIp = "";
        int port = 0;
        String reqMsg = "acquire\n885000\n";
        String line = socketClient.read(destIp, port ,reqMsg);
        if(StringUtils.isEmpty(line)){
            logger.warn("Can not read info from {} ",destIp + ":" + port);
            return;
        }
        String[] infoArray = line.split("#");
        List<ExchangeRatePrice> exchangeRatePrices = new ArrayList<>();
        for(String info : infoArray){
            String[] priceArray = info.split("\\|");
            ExchangeRatePrice exchangeRatePrice = new ExchangeRatePrice();
            exchangeRatePrice.setCurrency(priceArray[0]);
            exchangeRatePrice.setExchangePurchasePrice(priceArray[1]);
            exchangeRatePrice.setCashPurchasePrice(priceArray[2]);
            exchangeRatePrice.setSalePrice(priceArray[3]);
            exchangeRatePrice.setMiddlePrice(priceArray[4]);
            exchangeRatePrice.setModifyTime(DateUtil.parseStrToDate(priceArray[5], DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
            exchangeRatePrices.add(exchangeRatePrice);
        }
        exchangeRateService.saveExchangeRatePrices(exchangeRatePrices);
    }

    //测试记录
    //@Scheduled(fixedRate = 20 * 1000)
    public void taskTestExchangeRatePrice() {
        logger.info("taskTestExchangeRatePrice {} times", taskTestExchangeRatePriceCount++);
        List<ExchangeRatePrice> exchangeRatePrices = exchangeRateService.getExchangeRatePrices();
        if (exchangeRatePrices == null) {
            exchangeRatePrices = new ArrayList<>();
        }
        ExchangeRatePrice exchangeRatePrice = new ExchangeRatePrice();
        exchangeRatePrice.setCurrency("USD");
        exchangeRatePrice.setExchangePurchasePrice("epp" + taskTestExchangeRatePriceCount);
        exchangeRatePrice.setCashPurchasePrice("cpp" + taskTestExchangeRatePriceCount);
        exchangeRatePrice.setSalePrice("sp" + taskTestExchangeRatePriceCount);
        exchangeRatePrice.setMiddlePrice("mp" + taskTestExchangeRatePriceCount);
        exchangeRatePrice.setModifyTime(new Date());
        exchangeRatePrices.add(exchangeRatePrice);
        exchangeRateService.saveExchangeRatePrices(exchangeRatePrices);
    }
}
