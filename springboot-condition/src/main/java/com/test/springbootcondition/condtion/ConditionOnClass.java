package com.test.springbootcondition.condtion;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondtion.class)
public @interface ConditionOnClass {
    String[] value();
}
