package com.zdj.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author zhangdj
 * @date 2019/11/15
 * @PropertySource(value = {"classpath:dog.properties"}) 读取指定的配置文件 将配置文件中的属性赋值给类中的属性
 *
 */

@Data
@Validated
@Component
@ConfigurationProperties(value = "dog")
@PropertySource(value = {"classpath:dog.properties"})
public class Dog {

    @Email
    private String email;
}
