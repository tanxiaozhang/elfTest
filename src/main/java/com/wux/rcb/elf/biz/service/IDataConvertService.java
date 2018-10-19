package com.wux.rcb.elf.biz.service;

import com.wux.rcb.elf.biz.model.vo.DataConvertRule;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDataConvertService {

    List<DataConvertRule> getAllDataConvertRules();

    void importExcelData(MultipartFile file, Long id);
}
