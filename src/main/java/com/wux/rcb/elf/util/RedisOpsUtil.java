package com.wux.rcb.elf.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * REDIS的读写工具类
 * */
@Component
public class RedisOpsUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void saveObject(String key,Object object){
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(object));
    }
    public <T> T getObject(String key,Class<T> clazz){
        String value = stringRedisTemplate.opsForValue().get(key);
        return JSON.parseObject(value,clazz);
    }

    public <T> List<T> getArray(String key, Class<T> clazz){
        String value = stringRedisTemplate.opsForValue().get(key);
        return JSON.parseArray(value,clazz);
    }
}
