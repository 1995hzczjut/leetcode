package com.leetcode.array;


import java.util.Arrays;

/**
 * 主要是思路，要求不用额外的空间，还不能用除法，那么遍历两次，每次方向相反。
 *
 * @author Zhancong Huang
 * @date 23:30 2019/1/18
 */
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        //正向遍历.result[i] 代表i左边所有的积，i=0则是1
        for (int i = 0; i < n; i++) {
            result[i] = i == 0 ? 1 : (result[i - 1] * nums[i - 1]);
        }
        //反向遍历。不能再用数组了。rightProduct此时i右边的积
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new _238().productExceptSelf(nums)));
    }
}
