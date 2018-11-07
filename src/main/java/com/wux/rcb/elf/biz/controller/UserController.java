package com.wux.rcb.elf.biz.controller;

import com.wux.rcb.elf.annotation.ParamJson;
import com.wux.rcb.elf.annotation.ParamJsonHandlerMethodArgumentResolver;
import com.wux.rcb.elf.biz.model.vo.User;
import com.wux.rcb.elf.biz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends WebMvcConfigurationSupport {
    @Autowired
    IUserService userService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String main(@RequestBody Map<String, Object> map){
        User user = new User();

        userService.addUser(user);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ParamJson(value = "user")User userVo){
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
