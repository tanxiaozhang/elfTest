package com.wux.rcb.elf.biz.model.vo;

public class DataTableQueryVO {
    private Integer draw;

    /**分页大小默认10*/
    private Integer length = 10;

    /**默认开始记录下标*/
    private Integer start = 0;

    /**默认的开始页码*/
    private Integer pageNum=1;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    /** 页码 =  开始记录数/分页大小+1*/
    public Integer getPageNum() {
        return start/length+1;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
