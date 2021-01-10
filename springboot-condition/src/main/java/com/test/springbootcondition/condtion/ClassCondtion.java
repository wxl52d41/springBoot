package com.test.springbootcondition.condtion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class ClassCondtion implements Condition {
    /**
     * @param conditionContext      上下文对象。获取环境，IOC容器，ClassLoad对象
     * @param annotatedTypeMetadata 注解元对象。可以获取注解定义的属性值
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //导入通过注解属性值value指定坐标后创建Bean
        //动态获取注解属性值  value
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        System.out.println("map = " + map);//map = {value=[redis.clients.jedis.Jedis]}
        String[] value = (String[]) map.get("value");

        try {
           for(String className : value){
               Class<?> clz = Class.forName(className);
           }
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
