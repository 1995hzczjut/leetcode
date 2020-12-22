package com.jdk8.chap8;


/**
 * @author Zhancong Huang
 * @date 12:13 2019/3/10
 */
@FunctionalInterface
interface Task {
    public void execute();
}

public class demo1 {
    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }

    public static void main(String[] args) {
        //doSomething((Task) () -> System.out.println("xx"));
    }
}
