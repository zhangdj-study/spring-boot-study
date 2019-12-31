package com.zdj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangdj
 * @date 2019/11/16
 */
@ConfigurationProperties(prefix = "redis.config")
@Data
public class RedisProperties {

    private String address;

    private String port;
}
