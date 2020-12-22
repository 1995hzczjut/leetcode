package com.leetcode.annotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Zhancong Huang
 * @date 13:53 2018/12/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Debug(true)
public @interface doubleLevel {
    String value() ;
}
