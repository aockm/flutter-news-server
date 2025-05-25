package com.tockm.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration//表明这是一个配置类
@ConfigurationProperties(prefix = "security",ignoreInvalidFields = false)//该注解用于绑定属性。prefix用来选择属性的前缀，也就是在remote.properties文件中的“remote”，ignoreUnknownFields是用来告诉SpringBoot在有属性不能匹配到声明的域时抛出异常。
@PropertySource(value= "classpath:config/security.properties",ignoreResourceNotFound = false)//配置文件路径
//@Data//这个是一个lombok注解，用于生成getter&setter方法

@Component//标识为Bean
public class SecurityProperties {
    private String name;
    private String password;
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
