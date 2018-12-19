package com.wux.rcb.elf.biz.Task;

import com.wux.rcb.elf.biz.dao.info.GlfmxcmxDOMapper;
import com.wux.rcb.elf.biz.model.GlfmxcmxDO;
import com.wux.rcb.elf.biz.model.GlfmxdmxDO;
import com.wux.rcb.elf.biz.service.IGlfmxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 由客户信息管理系统定时读取客户分润信息
 * */
@Component
@EnableScheduling
public class CustomerProfitTask {

    @Autowired
    private IGlfmxService glfmxService;

    //存款信息
    private Map customerDeposit;

    //贷款信息
    private Map customerLoan;

    @Scheduled(fixedRate = 5*60*1000)
    public void taskReadCustomerProfit() {
        //查询存款数据，批量入库
        List<GlfmxcmxDO> glfmxcmxDOList = glfmxService.queryAllGlfmxcmx();
        List<GlfmxcmxDO> tempGlfmxcmxDOList = new ArrayList<>();
        for(GlfmxcmxDO GlfmxcmxDO : glfmxcmxDOList){
            while(tempGlfmxcmxDOList.size()<1000){

            }
        }

        //查询贷款数据，批量入库

        //完成分润比例
    }
}
