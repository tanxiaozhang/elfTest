package com.wux.rcb.elf.biz.dao.info;
import com.wux.rcb.elf.biz.model.GlfmxdmxDO;

import java.util.List;

public interface GlfmxdmxDOMapper {

    /**
     * 查询全量存款数据
     */
    List<GlfmxdmxDO> queryAllGlfmxdmx();

    /**
     * 查询增量存款数据
     * */
    List<GlfmxdmxDO> queryGlfmxdmxForUpdate();
}