package com.wux.rcb.elf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义属性加载类
 * */
@Configuration
@PropertySource(value="classpath:application.yml")
@ConfigurationProperties(prefix="elf")
public class YmlConfig {
    /**
     * 系统语言
     * */
    private String language;

    /**
     * 工资代发输入路径
     * */
    private String salaryInputPath;

    /**
     * 工资代发输出路径
     * */
    private String salaryOutputPath;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSalaryInputPath() {
        return salaryInputPath;
    }

    public void setSalaryInputPath(String salaryInputPath) {
        this.salaryInputPath = salaryInputPath;
    }

    public String getSalaryOutputPath() {
        return salaryOutputPath;
    }

    public void setSalaryOutputPath(String salaryOutputPath) {
        this.salaryOutputPath = salaryOutputPath;
    }
}
