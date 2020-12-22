package com.jianzhiOffer;

/**
 * 这个版本的答案非常优秀
 *
 * 考察特殊case:
 * (1)输入有正负号，也可以没有，没有又等价于有正好，所以可以先不看符号统一处理
 * （2）越界条件
 * （3）出现非数字
 *
 * @author Zhancong Huang
 * @date 18:32 2019/4/23
 */
public class p49 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;

        boolean isPositive = false;
        long pureNum = 0;

        if (str.startsWith("-")) {
            isPositive = false;
            pureNum = getPureNum(str, 1);
        } else if (str.startsWith("+")) {
            isPositive = true;
            pureNum = getPureNum(str, 1);
        } else {
            isPositive = true;
            pureNum = getPureNum(str, 0);
        }

        return calculate(isPositive, pureNum);
    }

    private int calculate(boolean isPositive, long pureNum) {
        long result = isPositive ? pureNum : -pureNum;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int)result;
    }


    private long getPureNum(String str, int start) {
        long result = 0;
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return 0;
            result = result * 10 + (str.charAt(i) - '0');
        }
        return result;
    }

}
