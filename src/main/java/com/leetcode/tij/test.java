package com.leetcode.tij;

/**
 * @author Zhancong Huang
 * @date 14:57 2018/9/29
 */
public class test {
    public static void main(String[] args) {
        //必须用外部类.内部类 表示type
        //new 关键字再外部类对象之后
//        Outer o = new Outer();
//        Outer.Inner i = o.new Inner();
//        Outer.Inner i1 = new Outer().new Inner();

        Outer.Inner i = new Outer.Inner();
    }
}
