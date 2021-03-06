package com.wux.rcb.elf.biz.model.vo;

import com.wux.rcb.elf.biz.constant.TipsEnum;
import com.wux.rcb.elf.config.YmlUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统一的访问返回对象
 * */
public class BaseResultVO {

    @Autowired
    private YmlUtil ymlUtil;

    //返回编码
    private int code;
    //返回信息
    private String message;
    //返回内容
    private Object resultData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    /**
     * 国际化返回信息
     * */
    public void generateMessage(String language, TipsEnum tip){
        if("CN".equals(language)){
            this.setMessage(tip.tipCN);
        }else{
            this.setMessage(tip.tipEN);
        }
    }
}
