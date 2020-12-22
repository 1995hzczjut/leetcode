package com.leetcode.annotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Zhancong Huang
 * @date 13:56 2018/12/26
 */
class A {
    @Debug(true)
    @doubleLevel("test_string")
    public void AA() {
    }
}
public class Main {
    public static void main(String[] args) {
        Class aClass = A.class;
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            //1.
            if (method.getAnnotation(Debug.class) != null && method.getAnnotation(doubleLevel.class) != null) {
                System.out.println("all");
            }
            //2. 另一种API
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Debug.class) {
                    Debug debug = (Debug) annotation;
                    System.out.println(debug.value());
                }
                if (annotation.annotationType() == doubleLevel.class) {
                    doubleLevel doubleLevel1 = (doubleLevel) annotation;
                    System.out.println(doubleLevel1.value());
                }
            }
        }
    }
}
