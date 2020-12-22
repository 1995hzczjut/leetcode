package com.leetcode.String;

/**
 * @author Zhancong Huang
 * @date 20:53 2019/5/12
 */
public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                //代表第一个字符就不匹配。长字符串指针右移
                si++;
            } else {
                //重点：不需要从头开始。因为有公共前后缀
                mi = next[mi];
            }
        }
        //短指针到头时退出才是找到了
        return mi == ms.length ? si - mi : -1;
    }

    /**
     * o（ms.len）
     */
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        //next 表示当前位置前面字符串的最大前后缀的长度，即前缀的后一位
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        //表示当前查看的子串的前一个子串的最长公共前缀的后一个
        //cn =0代表没有最大前缀
        int cn = 0;
        int count = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
            count++;
        }
        System.err.println(count);
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }
}
