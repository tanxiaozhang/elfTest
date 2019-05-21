package com.wux.rcb.elf.biz.constant;

/**
 * 提示信息枚举
 * */
public enum TipsEnum {
    TIP000001("登录成功！", "Login success!"),
    TIP000002("用户名或者密码错误！", "UserName or password error!"),
    TIP000003("验证码错误！", "ValidateCode error!"),
    TIP000004("操作成功！", "Request success!"),
    TIP000005("操作失败,请重试！", "Request fail，please retry!"),
    TIP000006("操作失败,参数异常！", "Request fail，params error!"),
    TIP000007("操作失败,记录已经存在！", "Request fail，records exists!"),
    TIP000008("操作失败,记录数值异常！", "Request fail，records exists!");

    public String tipCN;
    public String tipEN;

    TipsEnum(String tipCN, String tipEN){
        this.tipCN = tipCN;
        this.tipEN = tipEN;
    }
}
