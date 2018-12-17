package com.wux.rcb.elf.biz.model.vo;

/**
 * 统一的访问返回对象
 * */
public class BaseResultVo {
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
}
