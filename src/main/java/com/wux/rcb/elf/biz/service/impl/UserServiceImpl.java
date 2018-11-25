package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.UserDOMapper;
import com.wux.rcb.elf.biz.model.UserDO;
import com.wux.rcb.elf.biz.model.vo.UserVO;
import com.wux.rcb.elf.biz.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public Long addUser(UserVO userVO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO, userDO);
        userDOMapper.insert(userDO);
        return userDO.getId();
    }
}
