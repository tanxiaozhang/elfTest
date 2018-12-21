package com.wux.rcb.elf.biz.Task;

import com.wux.rcb.elf.biz.service.ISalaryConvertService;
import com.wux.rcb.elf.config.YmlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 工资自动转换定时任务
 * */
@Component
@EnableScheduling
public class SalaryConvertTask {

    private Logger logger = LoggerFactory.getLogger(SalaryConvertTask.class);
    @Autowired
    private ISalaryConvertService salaryConvertService;

    @Autowired
    private YmlConfig ymlConfig;

    @Scheduled(fixedRate = 1*60*1000)
    public void taskConvertSalary() {
        File inputFilePath = new File(ymlConfig.getSalaryInputPath());
        File outputFilePath = new File(ymlConfig.getSalaryOutputPath());
        if (!inputFilePath.isDirectory()) {
            logger.error("InputPath {} error! Stop! ", ymlConfig.getSalaryInputPath());
            return;
        }
        if (!outputFilePath.isDirectory()) {
            logger.error("OutputPath {} error! Stop!", ymlConfig.getSalaryOutputPath());
            return;
        }
        List<String> inputFiles = Arrays.asList(inputFilePath.list());
        List<String> outputFiles = Arrays.asList(outputFilePath.list());
        for (String inputFileName : inputFiles) {
            if (!(inputFileName.endsWith("xls") || inputFileName.endsWith("xlsx"))) {
                logger.info("File {} is not a excel file! Next!", inputFileName);
                continue;
            }
            String outputFileName = inputFileName.split("\\.")[0].split("-")[1] + ".data";
            if (outputFiles.contains(outputFileName)) {
                logger.info("File {} exists! Next!", outputFileName);
                continue;
            }
            salaryConvertService.convertSalary(ymlConfig.getSalaryInputPath(), inputFileName, ymlConfig.getSalaryOutputPath(), outputFileName);
        }
    }
}
