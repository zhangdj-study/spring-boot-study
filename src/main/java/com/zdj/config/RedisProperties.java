package com.zdj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangdj
 * @date 2019/11/16
 * @ConfigurationProperties  将类中的属性和配置文件的值进行绑定
 */
@Component
@ConfigurationProperties(prefix = "redis.config")
@Data
public class RedisProperties {

    private String address;

    private String port;
}
