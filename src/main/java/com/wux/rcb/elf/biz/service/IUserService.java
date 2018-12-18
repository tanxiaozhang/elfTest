package com.wux.rcb.elf.biz.service;

import com.wux.rcb.elf.biz.model.UserDO;
import com.wux.rcb.elf.biz.model.vo.UserVO;

public interface IUserService {
    Long addUser(UserVO userVO);

    UserDO validateUser(String userName, String password);

}
