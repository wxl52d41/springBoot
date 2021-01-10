package com.test.springbootcondition.condtion;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;

import org.springframework.core.type.AnnotatedTypeMetadata;
import redis.clients.jedis.Jedis;

public class ClassCondtion implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //1、导入jedis坐标后，加载该Bean,没导入，则不加载。

        //2.判断  redis.clients.jedis.Jedis 文件是否存在
        try {
            Class<?> clz = Class.forName("redis.clients.jedis.Jedis");
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
