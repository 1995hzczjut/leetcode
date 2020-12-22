package com.leetcode.slidingWindow;


/**
 * 滑动窗口问题的鼻祖：
 * 思路：我们定义一个头指针，定义一个尾指针，每一次我们头尾指针确定一个不重复的连续 的子串
 * 一旦我们遇到一个相同的我们就让头指针后移到不重复的位置然后维护我们的最大只存放的变量，知道我们的为指针扫描完整个的字符串
 * 直接输出最大的长度就可以啦
 *
 * 滑动窗口法：
 * 其实都能转化为DP，数组最值区间基本DP能解决，这里用dp[i]表示i之前数组的最大符合题意的子串
 * dp[i+1]就看i+1位置的字符d是否出现在Dp[i]代表的区域里面，DP更好理解。
 * 滑动窗口的滑动的过程：
 * 有窗口滑，滑到极限，此时左窗口往右滑，还不如DP好理解。
 * 难点依然在于怎么知道i+1是否出现在DP[i]
 *
 *  209同样的做法
 * @author Zhancong Huang
 * @date 20:07 2019/7/31
 */
public class _3 {

    /**
     * 之前的版本有问题：MAP一直维护全局的值，其实没有必要的，只维护窗口内的CharMap即可
     * 窗口滑的时候，更新Charmap即可，这种做法理解性更好。
     * 注意不区分大小写
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        //窗口初始1，有的时候0，即right指向-1，看情况
        int left = 0, right = 0;
        //动态维护[left,right]的，窗口外的都是0
        int[] charMap = new int[256];
        //滑动窗口基本右窗口作为全局变量
        for (; right < s.length(); right++) {
            //没遇到重复的
            if (charMap[s.charAt(right)] == 0) {
                charMap[s.charAt(right)] = 1;
                result = Math.max(result, right - left + 1);
            } else {
                //发现这个字符在[left,right]中某个位置出现过了
                //此时移动left到重复位置的右边，charMap要重置
                while (s.charAt(left) != s.charAt(right)) {
                    charMap[s.charAt(left++)] = 0;
                }
                //退出时left指向中间那个位置的重复值
                left++;
                //跟上面可以合并，懒的改了
                charMap[s.charAt(right)] = 1;
            }
        }
        return result;
    }


}
