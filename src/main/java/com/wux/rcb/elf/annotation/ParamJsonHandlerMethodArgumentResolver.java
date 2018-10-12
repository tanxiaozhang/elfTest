package com.wux.rcb.elf.annotation;

import java.io.BufferedReader;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import com.alibaba.fastjson.JSONObject;

public class ParamJsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ParamJson.class);
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ParamJson requestJson = parameter.getParameterAnnotation(ParamJson.class);
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1024];
        int rd;
        while ((rd = reader.read(buf)) != -1) {
            sb.append(buf, 0, rd);
        }
        JSONObject jsonObject = JSONObject.parseObject(sb.toString());
        String value = requestJson.value();
        return JSON.parseObject(jsonObject.get(value).toString(), parameter.getParameterType());
    }
}