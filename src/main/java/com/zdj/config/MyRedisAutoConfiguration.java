package com.zdj.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangdj
 * @date 2019/11/16
 *
 * @EnableConfigurationProperties(RedisProperties.class)  也可以不使用但是需要在RedisProperties加上@Component
 * 注解
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@Slf4j
public class MyRedisAutoConfiguration {

    private final RedisProperties redisProperties;

    public MyRedisAutoConfiguration(RedisProperties redisProperties){
        this.redisProperties = redisProperties;
    }

    @Bean
    public Redis redis(){
        Redis redis = new Redis();
        redis.setAddress(this.redisProperties.getAddress());
        redis.setPort(this.redisProperties.getPort());
        return redis;
    }
}
