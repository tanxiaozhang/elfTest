package com.wux.rcb.elf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * REDIS初始化配置
 * */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {
    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        return new JedisConnectionFactory(getRedisConfig());
    }

    @Bean
    public StringRedisTemplate getRedistemplate() {
        logger.info("redis初始化完成");
        return new StringRedisTemplate(getConnectionFactory());
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        stringRedisTemplate.setKeySerializer(stringSerializer);
//        stringRedisTemplate.setValueSerializer(stringSerializer);
//        stringRedisTemplate.setHashKeySerializer(stringSerializer);
//        stringRedisTemplate.setHashValueSerializer(stringSerializer);
//        stringRedisTemplate.setStringSerializer(stringSerializer);
//        stringRedisTemplate.setDefaultSerializer(stringSerializer);
//        return stringRedisTemplate;
    }

}
