package com.jianzhiOffer;

/**
 * 现场写肯定写不出来，要调试。
 *
 * @author Zhancong Huang
 * @date 14:28 2019/8/23
 */
public class p53 {

    /**
     * 考察对测试用例的思考
     */
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) return false;

        //是否出现过 E，e   .   +,-
        boolean hasE = false, dot = false, sign = false;

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == 'E' || c == 'e') {
                //不能出现两次
                if (hasE) return false;
                //E不能是最后一个
                if (i == str.length - 1) return false;
                hasE = true;
            } else if (c == '.') {
                //不能出现两次,且前面不能有E
                if (dot || hasE) return false;
                dot = true;
            } else if ( c == '+' || c == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("123.45e+6".toCharArray()));
    }
}
