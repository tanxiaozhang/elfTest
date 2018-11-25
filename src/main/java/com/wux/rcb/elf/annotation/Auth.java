package com.wux.rcb.elf.annotation;

import java.lang.annotation.*;

/**
 * 登录验证注解
 * */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}