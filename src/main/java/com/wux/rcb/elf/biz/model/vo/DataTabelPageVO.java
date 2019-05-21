package com.wux.rcb.elf.biz.model.vo;

/**
 * @Author Tan
 * @Date 2019-02-22
 * @Desc 配合jequary dataTable插件使用的分页对象
 * */
public class DataTabelPageVO extends BaseResultVO {

    private Long recordsTotal;

    private Long recordsFiltered;

    private Integer draw;

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }
}
