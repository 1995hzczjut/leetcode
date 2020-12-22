package com.jianzhiOffer;

/**
 * 注意对corner case的思考
 * n可别大怎办？字符串空也要确认
 *
 * @author Zhancong Huang
 * @date 10:34 2019/4/23
 */
public class p43 {
    public String LeftRotateString(String str, int n) {
        if (n == 0 || str.length() == 0) return str;
        //跟LC不一样，可能转很多圈
        n %= str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - n - 1);
        reverse(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        if (start >= end) return;

        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new p43().LeftRotateString("abcXYZdef", 0));
    }
}
