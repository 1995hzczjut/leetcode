package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 22:34 2019/2/3
 */
public class _263 {
    /**
     * 用递归做。直观上判断一个数是否为丑数，看它是否包括除235外的因子。那么可以尽量把235去掉
     * 注意特殊情况01
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        //终止条件
        if (num == 0){
            return false;
        }
        if (num == 1){
            return true;
        }
        if (num % 2 == 0){
            return isUgly(num / 2);
        }else if(num % 3 == 0){
            return isUgly(num / 3);
        }else if(num % 5 == 0){
            return isUgly(num / 5);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
