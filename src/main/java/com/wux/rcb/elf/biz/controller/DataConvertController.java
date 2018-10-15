package com.wux.rcb.elf.biz.controller;

import com.wux.rcb.elf.biz.service.IDataConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/dataConvert")
public class DataConvertController {
    @Autowired
    private IDataConvertService dataConvertService;

    @RequestMapping(value="/setting", method = RequestMethod.GET)
    public String one(Map<String, Object> map){
        map.put("title", "数据转换规则配置");
        return "biz/dataConvert/setting";
    }
}
