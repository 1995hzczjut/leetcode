package com.leetcode.bit_manipulation;

/**
 * 只有遇到第一个1才开始flip
 * 
 * @author Zhancong Huang
 * @date 0:00 2019/6/30
 */
public class _476 {
    public int findComplement(int num) {
        boolean flag = false;
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0) flag = true;
            if (flag){
                //怎么指定改变某一位？用异或
                num ^= (1 << i);
            }
        }
        return num;
    }
}
