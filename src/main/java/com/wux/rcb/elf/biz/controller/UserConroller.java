package com.wux.rcb.elf.biz.controller;

import com.wux.rcb.elf.annotation.ParamJson;
import com.wux.rcb.elf.annotation.ParamJsonHandlerMethodArgumentResolver;
import com.wux.rcb.elf.biz.constant.TipsEnum;
import com.wux.rcb.elf.biz.model.UserDO;
import com.wux.rcb.elf.biz.model.vo.BaseResultVo;
import com.wux.rcb.elf.biz.model.vo.UserVO;
import com.wux.rcb.elf.biz.service.IUserService;
import com.wux.rcb.elf.config.YmlUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
@EnableConfigurationProperties(value={YmlUtil.class})
public class UserConroller extends WebMvcConfigurationSupport {
    @Autowired
    IUserService userService;

    @Autowired
    private YmlUtil ymlUtil;

    /**
     * 用户登录方法
     * */
    @ResponseBody
    @RequestMapping(value="/userLogin", method = RequestMethod.POST)
    public Object userLogin(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password){
        BaseResultVo baseResultVo = new BaseResultVo();
        UserDO userDO = userService.validateUser(userName, password);
        if(userDO != null){
            UserVO userVO = new UserVO();
            baseResultVo.setCode(0);
            baseResultVo.generateMessage(ymlUtil.getLanguage(), TipsEnum.TIP000001);
            BeanUtils.copyProperties(userDO, userVO);
            baseResultVo.setResultData(userVO);
        }else{
            baseResultVo.setCode(1);
            baseResultVo.generateMessage(ymlUtil.getLanguage(), TipsEnum.TIP000002);
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
