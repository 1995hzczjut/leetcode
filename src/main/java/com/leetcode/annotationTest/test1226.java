package com.leetcode.annotationTest;

/**
 * @author Zhancong Huang
 * @date 23:16 2018/12/26
 */
class parent{
   public static void foo(){
       System.out.println("father static");
   }

}

 class child extends parent{
//    public static void foo() {
//        System.out.println("child static");
//    }
}


public class test1226 {
    public static void main(String[] args) {
//        parent p = new child();
//        p.foo();
//        child.foo();
        //child.foo();
        child c = new child();
        c.foo();
    }
}
