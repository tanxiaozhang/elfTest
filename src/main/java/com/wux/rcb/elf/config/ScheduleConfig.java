package com.wux.rcb.elf.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import java.util.concurrent.Executors;

/**
 * 定时器任务多线程并发
 * */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    private static final int poolSize = 10;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(poolSize));
    }
}
