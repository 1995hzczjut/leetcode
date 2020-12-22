package com.leetcode.tmp;


import com.leetcode.dfs.ListNode;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class ArrayMedium2 {


    public void helper(int num) {
        if (num <= 0) return;
        List<String> result = new LinkedList<>();
        doHelper(result, "", String.valueOf(num), 0);
        System.out.println(result);
    }

    public void doHelper(List<String> result, String tmp, String num, int idx){
        if (idx >= num.length()){
            System.out.println("ans:" + tmp);
            result.add(tmp);
        }
        for (int i = 1; i < 3; i++) {
            int nextStart = idx +i;
            if (nextStart >= num.length() + 1) continue;
            int s = Integer.valueOf(num.substring(idx, nextStart));
            if (s < 27){
                char c = (char) (s  - 1 + 'A');
                System.out.println("sub:" + c);
                doHelper(result, tmp + c, num, nextStart);
            }
        }
    }


    public static void main(String[] args) {
        ArrayMedium2 s = new ArrayMedium2();
        s.helper(1);
    }
}