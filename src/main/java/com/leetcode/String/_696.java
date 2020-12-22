package com.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class _696 {

    /**
     * 所有合法的数字可以看成两边，每一遍都是0或1，且数量相等。思考怎么产生的？
     * 00 1111 00 11.
     * 先按上面分片，然后每次挑连续的两个，这里比较三次。
     * 例如00 1111，能产生符合题意的有 0011 01.就是最短的那个的长度
     */
    public static int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        //遍历中每个位置处理他之前的结果，要在循环后单独处理一下。因为最后一段没人帮它看了。可以改。
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num++;
            } else {
                list.add(num);
                num = 1;
            }
        }
        list.add(num);
        int res = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            res += Math.min(list.get(i), list.get(i + 1));
        }
        return res;
    }

    /**
     * /(n)  O(1)
     * 优化空间。类似DP里的方法
     */
    public static int countBinarySubstrings1(String s) {
        int pre = 0;
        int num = 1;
        int res = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num++;
            } else {
                res += Math.min(pre, num);
                pre = num;
                num = 1;
            }
        }
        res += Math.min(pre, num);
        return res;
    }

    public static void main(String[] args) {
        countBinarySubstrings("11001100");
    }

}
