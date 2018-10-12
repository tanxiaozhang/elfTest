package com.wux.rcb.elf.biz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.wux.rcb.elf.annotation.ParamJson;
import com.wux.rcb.elf.annotation.ParamJsonHandlerMethodArgumentResolver;
import com.wux.rcb.elf.biz.model.vo.UserVo;
import com.wux.rcb.elf.biz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserConroller extends WebMvcConfigurationSupport {
    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ParamJson(value = "user")UserVo userVo){
        System.out.println(userVo);
        userService.addUser(userVo);
        return "OK";
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ParamJsonHandlerMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
}
