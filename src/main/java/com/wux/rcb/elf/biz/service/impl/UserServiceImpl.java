package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.UserDoMapper;
import com.wux.rcb.elf.biz.model.UserDo;
import com.wux.rcb.elf.biz.model.vo.User;
import com.wux.rcb.elf.biz.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Override
    public Long addUser(User userVo) {
        UserDo userDO = new UserDo();
        BeanUtils.copyProperties(userVo, userDO);
        userDoMapper.insert(userDO);
        return userDO.getId();
    }
}
