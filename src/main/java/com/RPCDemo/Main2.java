package com.RPCDemo;

/**
 * @author Zhancong Huang
 * @date 14:52 2019/7/7
 */
public class Main2 {
    public static void main(String[] args) {
        DemoService reference = RPCFramework.refer(DemoService.class, "127.0.0.1", 8756);
        System.out.println(reference.sayHello("dsds"));
    }
}
