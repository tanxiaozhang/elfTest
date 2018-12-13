package com.wux.rcb.elf.biz.dao.info;

import com.wux.rcb.elf.biz.model.GlfmxcmxDO;

import java.util.List;

public interface GlfmxcmxDOMapper {

    /**
     * 查询全量存款数据
     */
    List<GlfmxcmxDO> queryAllGlfmxcmx();

    /**
     * 查询增量存款数据
     * */
    List<GlfmxcmxDO> queryGlfmxcmxForUpdate();
}