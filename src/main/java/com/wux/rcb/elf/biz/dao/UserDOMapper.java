package com.wux.rcb.elf.biz.dao;

import com.wux.rcb.elf.biz.model.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO validateUser(@Param(value = "userName") String userName, @Param(value = "password")String password);
}