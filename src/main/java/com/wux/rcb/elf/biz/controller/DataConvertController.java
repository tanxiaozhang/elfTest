package com.wux.rcb.elf.biz.controller;

import com.wux.rcb.elf.biz.model.vo.DataConvertRule;
import com.wux.rcb.elf.biz.service.IDataConvertService;
import com.wux.rcb.elf.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/dataConvert")
public class DataConvertController {

    private Logger logger = LoggerFactory.getLogger(DataConvertController.class);

    @Autowired
    private IDataConvertService dataConvertService;


    @RequestMapping(value="/ruleList", method = RequestMethod.GET)
    public String ruleList(Map<String, Object> map){
        map.put("title", "规则列表");
        List<DataConvertRule> dataConvertRuleList = dataConvertService.getAllDataConvertRules();
        map.put("ruleList", dataConvertRuleList);
        map.put("newRule", new DataConvertRule());
        return "dataConvert/ruleList";
    }

    @RequestMapping(value="/del", method = RequestMethod.POST)
    @ResponseBody
    public String del(Map<String, Object> map){
        map.put("title", "规则删除");
        return "{}";
    }

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("ruleId") Long ruleId, Map<String, Object> map){
        map.put("title", "规则编辑");
        map.put("ruleId", ruleId);
        map.put("details",dataConvertService.findRuleDetails(ruleId));
        return "dataConvert/setting";
    }

    @RequestMapping(value="/addRule", method = RequestMethod.GET)
    public String add(Map<String, Object> map){
        map.put("title", "规则新增");
        return "dataConvert/setting";
    }

    @RequestMapping(value="/importRuleDetail", method = RequestMethod.POST)
    @ResponseBody
    public String importRuleDetail(@RequestParam("fileParam") MultipartFile file, @RequestParam("ruleId") Long ruleId){
        String fileName = file.getOriginalFilename();
        if (!ExcelUtil.checkExcelFileName(fileName)) {
            logger.error("File type error, fileName is {}", fileName);
            return "导入文件类型异常!";
        }
        dataConvertService.importRuleDetails(file, ruleId);
        return "{}";
    }

    @RequestMapping(value="/uploadData", method = RequestMethod.POST)
    @ResponseBody
    public String uploadData(@RequestParam("fileParam") MultipartFile file, @RequestParam("ruleId") Long ruleId){
        String fileName = file.getOriginalFilename();
        if (!ExcelUtil.checkExcelFileName(fileName)) {
            logger.error("File type error, fileName is {}", fileName);
            return "导入文件类型异常!";
        }
        dataConvertService.importExcelData(file, ruleId);
        return "{}";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadFileList(Map<String, Object> map) {
        List<DataConvertRule> dataConvertRuleList = dataConvertService.getAllDataConvertRules();
        map.put("ruleList", dataConvertRuleList);
        map.put("title", "数据文件上传");
        return "dataConvert/upload";
    }
}
