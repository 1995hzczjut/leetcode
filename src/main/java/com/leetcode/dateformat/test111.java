package com.leetcode.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhancong Huang
 * @date 14:28 2019/1/11
 */
public class test111 {
    public static void main(String[] args) {
        //单线程下的使用
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(simpleDateFormat.format(date));
        //线程安全
        System.out.println(ThreadLocalSDFUtil.format(date));
    }
}
