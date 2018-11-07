package com.wux.rcb.elf.biz.dao;

import com.wux.rcb.elf.biz.model.UserDo;

public interface UserDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
}