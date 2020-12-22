package com.jianzhiOffer;

/**
 * @author Zhancong Huang
 * @date 19:52 2019/4/16
 */
public class p2 {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        if (str.length() == 0) return "";

        char[] chars = str.toString().toCharArray();
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < chars.length; i++) {
            //不要写成 == “ ”
            if (chars[i] == ' ') {
                res.append("%20");
            } else {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy      ")));
    }
}
