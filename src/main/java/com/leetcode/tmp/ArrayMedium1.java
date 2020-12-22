package com.leetcode.tmp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Zhancong Huang
 * @date 18:29 2019/2/19
 */
public class ArrayMedium1 {

    /**
     * 10各随机数和为sum
     */
    public List<Integer> gen(int sum) {
        List<Integer> sorted = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sorted.add(ThreadLocalRandom.current().nextInt(0, sum + 1));
        }
        sorted.sort(Integer::compareTo);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add((i < 9 ? sorted.get(i ) : sum) - (i != 0 ? sorted.get(i - 1) : 0));
        }
        //System.out.println(res.stream().reduce(Integer::sum).get());
        return res;
    }

    public static void main(String[] args) {
        ArrayMedium1 s = new ArrayMedium1();
        int[] nums = {1, 1, 1, 2, 2, 3};
//        System.out.println(s.gen(55));
//        System.out.println(s.gen(415));
//        System.out.println(s.gen(1248));
//        System.out.println(s.gen(282));
        String c = new String("ss");
        //String a = c.intern();
        String b = "ss";
        System.out.println(c == b);

    }
}
