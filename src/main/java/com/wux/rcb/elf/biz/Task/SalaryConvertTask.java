package com.wux.rcb.elf.biz.Task;

import com.wux.rcb.elf.biz.service.ISalaryConvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 工资自动转换定时任务
 * */
@Component
@EnableScheduling
public class SalaryConvertTask {

    private Logger logger = LoggerFactory.getLogger(SalaryConvertTask.class);
    @Autowired
    private ISalaryConvertService salaryConvertService;

    @Scheduled(fixedRate = 5*60*1000)
    public void taskConvertSalary() {

    }
}
