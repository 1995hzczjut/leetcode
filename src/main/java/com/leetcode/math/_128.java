package com.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 找最长的连续子序列，还有道题目是找最长递增子序列，后者是DP做的，此题当然也能，但是题目要求时间复杂度O（n）
 * 所以DP肯定不行，排序也很简单，也是不行的。
 * 思路：
 * nums必定可以看成若干条连续子序列组成，给其中一个数，例如50，可以把50左右，例如48 49 51 52...全部扔掉
 * 然后记录最大的长度。巧妙之处在于利用set.remove的返回值,set还可以完美处理原始数组中带重复值的情况
 * 100, 4, 200, 1, 3, 2.  Num=4, 把4132全部删掉
 *
 * @author Zhancong Huang
 * @date 19:43 2019/11/2
 */
public class _128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>(256);

        for (int num : nums) {
            set.add(num);
        }

        int result = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int _num = num;
                int tmpLen = 1;
                while (set.remove(--_num)) tmpLen++;
                _num = num;
                while (set.remove(++_num)) tmpLen++;
                result = Math.max(result, tmpLen);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
