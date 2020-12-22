package com.jianzhiOffer;

import java.util.Stack;

/**
 * case: 123 321 ,123 312 ,1231 3121
 * 思路就是模拟Push, 遇到能pop的时候，把对应的全弹出来。然后继续push。贪心的思想，努力的匹配PopA数组
 * 最后看栈是否为空
 *
 * @author Zhancong Huang
 * @date 15:21 2019/4/20
 */
public class p21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0) return true;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[idx]){
                //stack.peek/pop 使用前一定要看是否为空
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
