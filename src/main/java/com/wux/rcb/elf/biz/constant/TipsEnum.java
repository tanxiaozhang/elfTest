package com.wux.rcb.elf.biz.constant;

/**
 * 提示信息枚举
 * */
public enum TipsEnum {
    TIP000001("登录成功", "Login success!"),
    TIP000002("用户名或者密码错误", "UserName or password error!");


    public String tipCN;
    public String tipEN;

    TipsEnum(String tipCN, String tipEN){
        this.tipCN = tipCN;
        this.tipEN = tipEN;
    }
}
