package com.wux.rcb.elf.biz.service.impl;

import com.wux.rcb.elf.biz.dao.elf.FtpDataImportDOMapper;
import com.wux.rcb.elf.biz.dao.info.GlfmxcmxDOMapper;
import com.wux.rcb.elf.biz.dao.info.GlfmxdmxDOMapper;
import com.wux.rcb.elf.biz.model.FtpDataImportDO;
import com.wux.rcb.elf.biz.model.GlfmxDO;
import com.wux.rcb.elf.biz.service.IGlfmxService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 信息管理系统存贷款明细服务实现类
 * */
public class GlfmxServiceImpl implements IGlfmxService {

    @Autowired
    private GlfmxcmxDOMapper glfmxcmxDOMapper;

    @Autowired
    private GlfmxdmxDOMapper glfmxdmxDOMapper;

    @Autowired
    private FtpDataImportDOMapper ftpDataImportDOMapper;

    /**
     * 全量初始化导入记录
     * */
    @Override
    public void initFtpImportData() {
        //存款初始化
        List<GlfmxDO> glfmxcmxDOList = glfmxcmxDOMapper.queryAllGlfmxcmx();
        translateData(glfmxcmxDOList);
        //贷款初始化
        List<GlfmxDO> glfdmxDOList = glfmxdmxDOMapper.queryAllGlfmxdmx();
        translateData(glfdmxDOList);
    }

    /**
     * 增量更新导入
     * */
    @Override
    public void updateFtpImportData() {

    }

    private void translateData(List<GlfmxDO> glfmxDOList){
        List<FtpDataImportDO> ftpDataImportDOList = new ArrayList<>();
        FtpDataImportDO flagRecord = null;
        while (glfmxDOList.iterator().hasNext()){
            GlfmxDO glfmxDO = glfmxDOList.iterator().next();
            FtpDataImportDO ftpDataImportDO = this.copyGlfmxValues(glfmxDO);
            ftpDataImportDO.setImportMode("1");
            /**
             * 分润补充逻辑，对账号已经排序的记录，若分润记录为一组内，则叠加分润比例
             * 若分润记录为不同组别，则区分分润是否已经完整，不完整的还需要添加一条上次分润的补充记录
             * */
            if (flagRecord == null || StringUtils.equals(flagRecord.getAccountNo(), glfmxDO.getAccountNo())) {
                ftpDataImportDOList.add(ftpDataImportDO);
                flagRecord.setPaiRate(flagRecord.getPaiRate() + glfmxDO.getPaiRate().divide(new BigDecimal(100)).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue());
            } else {
                if(flagRecord.getPaiRate() < 1){
                    flagRecord.setManagerId("机构柜员号");
                    flagRecord.setPaiRate(1-flagRecord.getPaiRate());
                    ftpDataImportDOList.add(flagRecord);
                }
                flagRecord = ftpDataImportDO;
                /**
                 * 数据入库，此处入库会保持记录的连贯性
                 * */
                if(ftpDataImportDOList.size() > 1000){
                    ftpDataImportDOMapper.batchInsert(ftpDataImportDOList);
                }
            }
        }
    }

    private FtpDataImportDO copyGlfmxValues(GlfmxDO glfmxDO){
        FtpDataImportDO ftpDataImportDO = new FtpDataImportDO();
        ftpDataImportDO.setAccountNo(glfmxDO.getAccountNo());
        // 01:存款  02:贷款
        ftpDataImportDO.setAcctType("01");
        ftpDataImportDO.setDealStatus("0");
        ftpDataImportDO.setAcctType(glfmxDO.getAccountType());
        ftpDataImportDO.setPrimCstId(glfmxDO.getCustomerNo());
        ftpDataImportDO.setManagerId(glfmxDO.getCustomerManagerNo());
        ftpDataImportDO.setRprgOuIpId(glfmxDO.getOrgNo());
        ftpDataImportDO.setStrDate(glfmxDO.getStartDate());
        ftpDataImportDO.setEndDate(glfmxDO.getEndDate());
        ftpDataImportDO.setManagerId(glfmxDO.getCustomerManagerNo());
        ftpDataImportDO.setPaiRate(glfmxDO.getPaiRate().divide(new BigDecimal(100)).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue());
        return ftpDataImportDO;
    }
}
