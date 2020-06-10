package com.zdj;

import com.zdj.config.Redis;
import com.zdj.model.Dog;
import com.zdj.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private Dog dog;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Redis redis;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void contextLoads2() {
        System.out.println(dog);
    }

    @Test
    public void contextLoads3() {
        boolean b = applicationContext.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads4() {
        log.trace("trace级别");
        log.debug("debug级别");
        log.info("info级别");
        log.warn("warn级别");
        log.error("error级别");
        System.out.println(redis);
    }

    @Test
    public void contextLoads5() {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("trace级别");
        logger.debug("debug级别");
        logger.info("info级别");
        logger.warn("warn级别");
        logger.error("error级别");
        System.out.println(redis);
    }

    @Test
    public void contextLoads6() {
        boolean b = applicationContext.containsBean("myService");
        System.out.println(b);
    }
}
