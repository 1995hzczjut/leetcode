package com.leetcode.array;

/**
 * 只有9999 这种才能数组变长，这时候重新申请一个，第0位变为0就可以了
 * 其余情况不用变长.
 * case; 99 19  123【这三种想清楚了这道题就好做了】
 * @author Zhancong Huang
 * @date 0:52 2019/1/8
 */
public class _66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            //这个数为9，就变为0.进位的下一个数如果小于9，则这个数加1返回。或则他也为0，再往前看
            digits[i] = 0;
        }
        //走到这里代表是999这样的数字了
        int[] newNumber = new int [digits.length+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
