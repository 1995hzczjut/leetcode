package com.jianzhiOffer;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * LC47原题，注意这么排列符合字典序
 *
 * @author Zhancong Huang
 * @date 15:21 2019/4/21
 */
public class p27 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) return result;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        helper(result, new StringBuilder(), chars, used);
        return result;
    }


    private static void helper(ArrayList<String> result, StringBuilder tmpString, char[] chars, boolean[] used) {
        if (tmpString.length() == chars.length){
            result.add(tmpString.toString());
            //这个return也经常漏
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || i > 0 && !used[i - 1] && chars[i] == chars[i - 1]) continue;
            used[i] = true;
            tmpString.append(chars[i]);
            helper(result, tmpString, chars, used);
            tmpString.deleteCharAt(tmpString.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Permutation("112"));
    }
}
