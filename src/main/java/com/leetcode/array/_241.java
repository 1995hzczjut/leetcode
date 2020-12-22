package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求表达式自由加括号后的计算值。不管怎么加都无外乎（左子表达式）+运算符+（右子表达式）的pattern,然后子表达式又可以按照这个模式再分
 * 递归最好的选择，递归终止就是没有运算符，即单个数字
 *
 * @author Zhancong Huang
 * @date 19:50 2018/11/13
 */
public class _241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+') {
                String leftSub = input.substring(0, i);
                String rightSub = input.substring(i + 1, input.length());
                List<Integer> leftPart = diffWaysToCompute(leftSub);
                List<Integer> rigthPart = diffWaysToCompute(rightSub);
                //上面leftPart rigthPart 可能包含多个值，需要得到笛卡儿积
                for (Integer leftNum : leftPart) {
                    for (Integer rightNum : rigthPart) {
                        int c = 0;
                        //注意switch语法
                        switch (input.charAt(i)) {
                            case '*':
                                c = leftNum * rightNum;
                                break;
                            case '+':
                                c = leftNum + rightNum;
                                break;
                            case '-':
                                c = leftNum - rightNum;
                                break;
                            default:
                        }
                        res.add(c);
                    }
                }
            }

        }
        //递归终止条件
        if (res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(new _241().diffWaysToCompute(s));
    }
}
