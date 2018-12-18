package com.wux.rcb.elf.biz.controller;

import com.wux.rcb.elf.annotation.ParamJson;
import com.wux.rcb.elf.annotation.ParamJsonHandlerMethodArgumentResolver;
import com.wux.rcb.elf.biz.constant.TipsEnum;
import com.wux.rcb.elf.biz.model.vo.BaseResultVo;
import com.wux.rcb.elf.biz.model.vo.UserVO;
import com.wux.rcb.elf.biz.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserConroller extends WebMvcConfigurationSupport {
    @Autowired
    IUserService userService;

    /**
     * 用户登录方法
     * */
    @ResponseBody
    @RequestMapping(value="/userLogin", method = RequestMethod.POST)
    public Object userLogin(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password){
        BaseResultVo baseResultVo = new BaseResultVo();
        boolean userExistFlag = userService.validateUser(userName, password);
        if(userExistFlag){
            baseResultVo.setCode(0);
            baseResultVo.generateMessage(TipsEnum.TIP000001);
        }else{
            baseResultVo.setCode(1);
            baseResultVo.generateMessage(TipsEnum.TIP000002);
        }
        return baseResultVo;
    }

    @ResponseBody
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ParamJson(value = "user")UserVO userVO){
        System.out.println(userVO);
        userService.addUser(userVO);
        return "OK";
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ParamJsonHandlerMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
}
