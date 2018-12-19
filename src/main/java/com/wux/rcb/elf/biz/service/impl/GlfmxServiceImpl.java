package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.info.GlfmxcmxDOMapper;
import com.wux.rcb.elf.biz.dao.info.GlfmxdmxDOMapper;
import com.wux.rcb.elf.biz.model.GlfmxcmxDO;
import com.wux.rcb.elf.biz.model.GlfmxdmxDO;
import com.wux.rcb.elf.biz.service.IGlfmxService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 信息管理系统存贷款明细服务实现类
 * */
public class GlfmxServiceImpl implements IGlfmxService {

    @Autowired
    GlfmxcmxDOMapper glfmxcmxDOMapper;

    @Autowired
    GlfmxdmxDOMapper glfmxdmxDOMapper;

    //查询全量存款信息
    @Override
    public List<GlfmxcmxDO> queryAllGlfmxcmx() {
        return glfmxcmxDOMapper.queryAllGlfmxcmx();
    }

    //查询全量贷款信息
    @Override
    public List<GlfmxdmxDO> queryAllGlfmxdmx() {
        return glfmxdmxDOMapper.queryAllGlfmxdmx();
    }
}
