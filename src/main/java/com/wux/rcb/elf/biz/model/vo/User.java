package com.wux.rcb.elf.biz.model.vo;

import lombok.Data;

@Data
public class User extends BaseVo {

    private String userName;

    private Long password;

    private String status;

    private String nickName;

}
