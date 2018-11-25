package com.wux.rcb.elf.biz.model.vo;

import com.wux.rcb.elf.biz.model.UserDO;

public class UserVO extends UserDO {

    private String userImgUrl = "zz";

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }
}
