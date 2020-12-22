package com.leetcode.slidingWindow;

/**
 * 209，3一起构成最经典的滑动窗口。209找全局最大的窗口，3找全局最小的窗口。
 * 可以总结出两个模板。
 *
 * @author Zhancong Huang
 * @date 16:02 2019/8/12
 */
public class _209 {

    /**
     * 找全局最小窗口，有模板的
     */
    public int minSubArrayLen1(int s, int[] nums) {
        //sum动态维护窗口的和
        int left = 0, right = 0, sum = 0, result = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            sum += nums[right];
            if (sum < s) {
                //当前窗口不合法，只能依靠右窗口移动
                //left左移动就跟之前的重复了
                continue;
            } else {
                //当前窗口合法，因为要求全局最小合法窗口，这里就是借助DP的思想，找到以right为右边界的最小窗口
                //只要合法，就不断的压缩。注意left,right指向同一处也是合法的
                while (sum >= s && left <= right) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left++];
                }
                //走到这里，窗口是不合法的，但是是最接近合法的以右边界为底的窗口
                //注意可能Nums[i]自己构成的窗口合法，此时left在right右边。
            }
        }
        //可能窗口一次也没更新过
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        System.out.println(new _209().minSubArrayLen1(4, nums));
    }

}
