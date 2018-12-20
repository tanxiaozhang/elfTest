package com.wux.rcb.elf.biz.dao.elf;

import com.wux.rcb.elf.biz.model.FtpDataImportDO;
import com.wux.rcb.elf.biz.model.FtpDataImportDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FtpDataImportDOMapper {
    int countByExample(FtpDataImportDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FtpDataImportDO record);

    int insertSelective(FtpDataImportDO record);

    List<FtpDataImportDO> selectByExample(FtpDataImportDOExample example);

    FtpDataImportDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FtpDataImportDO record);

    int updateByPrimaryKey(FtpDataImportDO record);

    void batchInsert(@Param(value = "importDataList") List<FtpDataImportDO> ftpDataImportDOList);
}