package com.leetcode.slidingWindow;


/**
 * 一般情况下，第一直接想不到是此类问题，但是一般都能看出
 * 是DP问题，而且是以XX为底的类型，然后具有下面特点：
 * （1）dp[i]仅依赖于dp[i-1]和nums[i]
 * （2）dp[i-1]不满足的话，可以压缩dp[i-1]到一个值，然后不用继续了。跳过的值以后也不会看了
 * 通常具有上面第一个特征的都能转化为滑动窗口问题，做法：
 * （1）方便的话直接用dp做
 * （2）不方便的话，主要体现在dp状态值要反应很多东西，考虑滑动窗口。
 * 用一个状态对象维护窗口。
 *
 * 基本的滑动窗口问题模板，一定要理解窗口大小变化的动态过程
 * 2019/8/17: 不要死板的套，牢记背后是以X为底的DP，有时候窗口合不合法都压。LC795
 * 基本的结构要记下来。
 *
 * @author Zhancong Huang
 * @date 17:28 2019/8/12
 */
public class SlidingWindowUtil {

    /**
     * 对应LC3
     */
    public int findMaxWindow(int[] nums) {
        int result = 0;
        //窗口
        int left = 0, right = 0;
        //动态的维护窗口的合法状态
        Object o = new Object();
        for (; right < nums.length; right++) {
            //走到这里o还是在维护老的窗口
            change(o);
            //准备确认窗口合法性
            if (check(o)) {
                //代表窗口合法，此时窗口大小才被确认，可能要改变o，o永远是动态维护的
            } else {
                //窗口不合法，准备left右移压缩
                //直到合法，或者left>right代表此时根本找不到以这个right为底的窗口
                while (!check(o) && left <= right) {
                    left++;
                    change(o);
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    /**
     * 对应LC209
     */
    public int findMinWindow(int[] nums) {
        int result = Integer.MAX_VALUE;
        //窗口
        int left = 0, right = 0;
        //动态的维护窗口的合法状态
        Object o = new Object();
        for (; right < nums.length; right++) {
            change(o);
            //准备确认窗口合法性
            if (!check(o)) {
                //代表不合法
                continue;
            } else {
                //窗口合法，准备left右移压缩,尝试找到最小的那个
                //直到不合法，或者left>right代表nums[right]自己就合法了
                while (check(o) && left <= right) {
                    result = Math.min(result, right - left + 1);
                    left++;
                    change(o);
                }
            }
        }
        return result;
    }


    /**
     * 改变当前窗口的状态
     */
    private void change(Object o) {
    }

    /**
     * 判断当前窗口是否合法
     */
    private boolean check(Object o) {
        return false;
    }
}
