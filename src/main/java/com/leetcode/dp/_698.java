package com.leetcode.dp;

import com.leetcode.Backtracking._78;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 9/30 没搞懂为什么start=i,还要用Used
 *
 * @author Zhancong Huang
 * @date 19:57 2019/9/29
 * @see _78
 * @see _416
 */
public class _698 {

    /**
     * 背景知识：数组的subset问题，78（找出一个数组中的所有subset）
     * 问题的简化版：找到一个subset等于特定值.
     * 最后会找到所有的subset
     */
    public List<Integer> findOneSubset(int[] nums, int target) {
        List<Integer> res = new LinkedList<>();
        findOneSubset0(nums, 0, new LinkedList<>(), target);
        return res;
    }

    private void findOneSubset0(int[] nums, int start, List<Integer> tmp, int remain) {
        if (remain == 0) {
            System.out.println(tmp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            findOneSubset0(nums, i + 1, tmp, remain - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }


    /**
     * 上面的方法可找到一个，原始问题转化成找n个subset，每个和为特定值
     * 但是找到一个不返回，而是再去找第二个。。。。依次类推
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) {
            return false;
        }
        int target = totalSum / k;
        boolean[] used = new boolean[nums.length];
        return canPartitionKSubsets0(nums, 0, used, target, k, target);
    }

    /**
     * 这里只要找到一个就返回true
     *
     * @param k 还剩下k个subset要寻找。等于1的时候就不用找了，剩下的就是
     */
    private boolean canPartitionKSubsets0(int[] nums, int start, boolean[] used, int remain, int k, int target) {
        if (k == 1) {
            return true;
        }
        if (remain < 0) {
            return false;
        }
        if (remain == 0) {
            //开始寻找下一组
            return canPartitionKSubsets0(nums, 0, used, target, k - 1, target);
        }
        //不能写在这里，当前点已经处理过了。应该设置再里面。参考combination
        //used[i] == true;
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (canPartitionKSubsets0(nums, i, used, remain - nums[i], k, target)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}
