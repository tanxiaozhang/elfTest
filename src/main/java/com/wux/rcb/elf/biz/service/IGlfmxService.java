package com.wux.rcb.elf.biz.service;

import com.wux.rcb.elf.biz.model.GlfmxcmxDO;
import com.wux.rcb.elf.biz.model.GlfmxdmxDO;

import java.util.List;

/**
 * 信息系统存贷款明细服务接口
 * */
public interface IGlfmxService {
    List<GlfmxcmxDO> queryAllGlfmxcmx();

    List<GlfmxdmxDO> queryAllGlfmxdmx();
}
