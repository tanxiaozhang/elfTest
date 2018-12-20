package com.wux.rcb.elf.biz.service;

import java.io.File;

public interface ISalaryConvertService {
    void convertSalary(String inputFilePath, String inputFileName, String outputFilePath, String outputFileName);
}
