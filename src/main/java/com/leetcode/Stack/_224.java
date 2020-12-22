package com.leetcode.Stack;

import java.util.Stack;

/**
 * 思路：不考虑括号，1+2-3看成 （-1）+（+2）+（-3）
 * 括号代表进入一个新的运算，各变量意义如下：
 * result：当前运算从开始到现在的结果。遇到括号，代表进入新的运算，当前result要么压在栈帧，或者自定义的栈。
 * number：数字的累计
 * sign：（-1）+（+2）+（-3） 各个括号里的+，-
 *
 * @author Zhancong Huang
 * @date 18:35 2020/5/12
 */
public class _224 {

    static int i = 0;

    /**
     * 递归版本，之前做过类似的。不依赖静态变量的，可以修改返回值，额外返回出去时位于字符串idx的指针位置
     */
    public static int calculate1(String s) {

        int result = 0;
        int number = 0;
        int sign = 1;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                i++;
                result += sign * calculate1(s);
            }else if(c == ')'){
                result += sign * number;
                return result;
            }
        }

        if(number != 0) result += sign * number;
        return result;

    }


    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        //result是理解的重点，一整个运算分为不同级别，括号开始代表进入新的级别
        //result永远代表当前级别，遇到+ - 号一定代表在同一个级别
        //遇到（代表进入下一个级别
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //切换运算级别，肯定先压栈。
                stack.push(result);
                stack.push(sign);
                //正式进入新的运算级别，r,s都要变为初始值
                sign = 1;
                result = 0;
            }else if(c == ')'){
                //代表当前()代表的级别运算完了，先把)前面的数字加到result
                result += sign * number;
                number = 0;
                //准备回到上一个级别，先拿到(进去前的sign
                result *= stack.pop();
                //再把()结果加到上一个级别的result
                result += stack.pop();

            }
        }
        //处理纯数字的情况
        if(number != 0) result += sign * number;
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(calculate("1+(4+5+2)-3+(6+8)"));
        //System.out.println(calculate("1+(2-(3+4))"));
        String s = "1+(2-(3+4))";
        //String s = "1+(4-3)";
    }


}
