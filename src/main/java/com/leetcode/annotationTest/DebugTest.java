package com.leetcode.annotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@interface Debug{
    boolean value() default false;
}


public class DebugTest {
    public static void main(String[] args) {
        //注意注解里面放的只能是属性
        //用reflect获取这个类的方法
        Class debugTestClass = DebugTest.class;
        Method[] methods = debugTestClass.getMethods();
        for (Method method:
             methods) {
            method.setAccessible(true);
            //检查方法使用了注解
            if(method.isAnnotationPresent(Debug.class)){
                //关键：拿到注解的实例，注解就像类一样
                Debug debug = method.getAnnotation(Debug.class);
                String name = method.getName();
                if(debug.value()){
                    System.out.println("method:"+name+" should be debug");
                }else{
                    System.out.println("method:"+name+" should not be debug");
                }
            }

        }

    }

    @Debug()
    public void testMethod1() {
    }
    @Debug(true)
    public void testMethod2() {
    }

    @Debug(false)
    public void testMethod4() {
    }


}
