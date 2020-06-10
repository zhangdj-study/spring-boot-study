package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhangdj
 * @date 2019/10/10
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class HelloWorldApplication {
    public static void main(String[] args) {
        //启动
        SpringApplication.run(HelloWorldApplication.class,args);
    }
}
