package com.jianzhiOffer;



/**
 * 题目隐含的意思：
 * in-place, 搞个栈肯定是不行的。
 * 而且输入有多个空格，split不能用，要么正则，也不允许
 * 思路：全局反转，然后局部反转，局部反转用了滑动窗口发
 * <p>
 * 字符串操作等统一变成char，最后再转，避免意外
 *
 * @author Zhancong Huang
 * @date 13:29 2019/4/23
 */
public class p44 {

    public String ReverseSentence(String str) {
        if (str == null || "".equals(str.trim())) return str;

        int left = 0, right = 0;
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        while (right < str.length()) {
            while (left < str.length() && chars[left] == ' ') {
                left++;
            }
            right = left;
            while (right < str.length() && chars[right] != ' ') {
                right++;
            }
            reverse(chars, left, right - 1);
            left = right;
        }
        return new String(chars);
    }


    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

}
