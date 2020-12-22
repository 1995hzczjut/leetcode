package com.leetcode.tij;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 14:50 2018/9/29
 */
public class Outer {

    public  Outer(int j) {
        this.j = j;
    }

    int j = Inner.i;
    //int j = new Inner().i;


   static class Inner{
        static int i = 0;
    }

    public static void f(StringBuilder o){
        System.out.println("sb");
    }

    public static void f(String o){
        System.out.println("s");
    }

    public static void f(StringBuffer o){
        System.out.println("sbf");
    }

    public static void main(String[] args) {
        int i,j;
//        for(i = 0,j = 0; i + j < 20; ++i, j += i--){
//            System.out.println(i + j);
//        }
        i = 1;
        j = 1;
        j += i--;
        System.out.println(j);
    }

    public static void set(Map map){
       map = null;
    }
}
