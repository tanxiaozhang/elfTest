package com.wux.rcb.elf.config;

import com.wux.rcb.elf.biz.constant.TipsEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义属性加载类
 * */
@Configuration
@PropertySource(value="classpath:application.yml")
@ConfigurationProperties(prefix="elf")
public class YmlUtil {
    /**
     * 系统语言
     * */
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String generateMessage(TipsEnum tipsEnum){
        if("CN".equals(this.getLanguage())){
            return tipsEnum.tipCN;
        }else{
            return tipsEnum.tipEN;
        }
    }
}
