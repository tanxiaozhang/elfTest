package com.wux.rcb.elf.biz.dao.info;
import com.wux.rcb.elf.biz.model.GlfmxDO;

import java.util.List;

public interface GlfmxdmxDOMapper {

    /**
     * 查询全量存款数据
     */
    List<GlfmxDO> queryAllGlfmxdmx();

    /**
     * 查询增量存款数据
     * */
    List<GlfmxDO> queryGlfmxdmxForUpdate();
}