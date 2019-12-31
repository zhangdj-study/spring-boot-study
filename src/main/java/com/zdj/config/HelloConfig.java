package com.zdj.config;

import com.zdj.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangdj
 * @date 2019/11/15
 * @Configuration 表明该类是一个配置类
 */
@Configuration
public class HelloConfig {

    @Bean
    public HelloService helloService(){
        System.out.println("将返回值放入容器中，id为方法名字");
        return new HelloService();
    }
}
