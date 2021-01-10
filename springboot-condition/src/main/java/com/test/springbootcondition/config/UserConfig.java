package com.test.springbootcondition.config;

import com.test.springbootcondition.condtion.ClassCondtion;
import com.test.springbootcondition.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    @Conditional(ClassCondtion.class)//根据条件对象来创建，如果match方法返回的true,则创建对象bean
    public User user(){
        return new User();
    }
}
