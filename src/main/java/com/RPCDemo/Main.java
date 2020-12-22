package com.RPCDemo;

/**
 * @author Zhancong Huang
 * @date 14:48 2019/7/7
 */
public class Main {
    public static void main(String[] args) {
        DemoService exporter = new DemoServiceImpl();
        RPCFramework.export(exporter.getClass(), 8756);

    }
}
