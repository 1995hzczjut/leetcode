package com.leetcode.math;

/**
 *  跟链表的加法一样，注意进位，one-pass.SB的append没有指定位置插入的方法
 * @author Zhancong Huang
 * @date 9:47 2019/4/12
 */
public class _67 {
    public String addBinary(String a, String b) {
        int p = a.length() - 1, q = b.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (p >= 0 || q >= 0 || carry ==1){
            int num1 = p >= 0 ? a.charAt(p--) - '0' : 0;
            int num2 = q >= 0 ? b.charAt(q--) - '0' : 0;
            //之前是10
            int sum = (num1 + num2 + carry) % 2;
            carry = (num1 + num2 + carry) / 2;
            //append没有指定位置插入的功能
            res.insert(0, sum);
        }
        return res.toString();
    }
}
