package com.zdj.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2019/11/14
 *
 * @ConfigurationProperties 配置文件中的值与本类中的属性进行绑定
 * @Component 加入容器
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private Date birth;

    private List<Object> objectList;

    private Map<String,Object> map;

}
