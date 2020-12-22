package com.leetcode.tmp;

/**
 * @author Zhancong Huang
 * @date 19:22 2019/3/15
 */
class ConstC {
    static {
        System.out.println("ConstC init!");
    }

    public ConstC() {
        System.out.println("ConstC ");
    }

    //不触发初始化
    public static final String HELLO = "hello world!";
    //触发初始化
    //public static  String HELLO = "hello world!";

}

public class NotInit {

    public static void main(String[] args) {
        //经过编译优化，静态常量HELLO已经存到NotInit类自身常量池中，不会加载ConstC
        System.out.println(ConstC.HELLO);
    }
}
