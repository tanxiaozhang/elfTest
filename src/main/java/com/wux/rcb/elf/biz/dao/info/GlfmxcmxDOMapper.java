package com.wux.rcb.elf.biz.dao.info;

import com.wux.rcb.elf.biz.model.GlfmxDO;

import java.util.List;

public interface GlfmxcmxDOMapper {

    /**
     * 查询全量存款数据
     */
    List<GlfmxDO> queryAllGlfmxcmx();

    /**
     * 查询增量存款数据
     * */
    List<GlfmxDO> queryGlfmxcmxForUpdate();
}