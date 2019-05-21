package com.wux.rcb.elf.util;

import com.github.pagehelper.PageInfo;
import com.wux.rcb.elf.biz.model.vo.DataTabelPageVO;

/** 分页处理工具类*/
public class PageUtil {
    public static DataTabelPageVO translatePageForWeb(PageInfo pageInfo){
        DataTabelPageVO dataTabelPageVO = new DataTabelPageVO();
        dataTabelPageVO.setResultData(pageInfo.getList());
        dataTabelPageVO.setRecordsTotal(pageInfo.getTotal());
        dataTabelPageVO.setRecordsFiltered(pageInfo.getTotal());
        return dataTabelPageVO;
    }
}
