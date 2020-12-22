package com.jianzhiOffer;

/**
 * 思路：
 * 如果sequence合法的话一定能分为 小大中三块，小大看成左子树和右子树。
 * sequence合法 等价于 小大中三块满足大小关系&&小，大自己是合法的
 * 很容易遗漏第一个条件。
 * 同时【数组递归】的基本写法和终止条件不能忘。同样数组递归最常犯的错误，start,end总是写成0，-1.忘记自己处在递归里面
 *
 * @author Zhancong Huang
 * @date 11:54 2019/4/21
 */
public class p23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return helper(sequence, 0, sequence.length - 1);
    }


    private boolean helper(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int i = start;
        //找右子树起点
        while (sequence[i] < sequence[end]) {
            i++;
        }
        //验证右子树是否全部大于root，不是直接返回。
        //这里很容易忘记，直接去递归
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return helper(sequence, start, i - 1) && helper(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        p23 s = new p23();
        System.out.println(s.VerifySquenceOfBST(new int[]{4,7,5,12,17,15,10}));
    }
}
