package com.exem.past;


import java.util.*;

/**
 * @author Zhancong Huang
 * @date 19:07 2019/9/6
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        helper(num);
    }

    public static void helper(int num) {
        if (num <= 0) return;
        List<String> result = new LinkedList<>();
        doHelper(result, "", String.valueOf(num), 0);
        for(String s : result){
            System.out.println(s);
        }
    }

    public static void doHelper(List<String> result, String tmp, String num, int idx){
        if (idx >= num.length()){
            result.add(tmp);
        }
        for (int i = 1; i < 3; i++) {
            int nextStart = idx +i;
            if (nextStart >= num.length() + 1) continue;
            int s = Integer.valueOf(num.substring(idx, nextStart));
            if (s < 27){
                char c = (char) (s  - 1 + 'A');
                doHelper(result, tmp + c, num, nextStart);
            }
        }
    }


}
