package com.leetcode.dp;

import com.leetcode.Backtracking._78;

import java.util.Arrays;

/**
 * 两种思路：
 * （1）转坏为78的遍历subset问题
 * （2）转为01背包问题
 *
 * @author Zhancong Huang
 * @date 19:50 2018/12/1
 * @see _698
 * @see _78
 */
public class _416 {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) return false;
        return helper(0, nums, 0, totalSum / 2);
    }

    /**
     * 借助78，给定一个数组，找出所有的subset.注意跟90的区别
     * 90找出所有的subset，复杂很多，要用used数组
     * 78只要按 123  23 3  3 排就是了
     */
    private boolean helper(int prefix, int[] nums, int start, int target) {
        if (prefix == target) return true;
        for (int i = start; i < nums.length; i++) {
            if (helper(prefix + nums[i], nums, i + 1, target)) return true;
        }
        return false;
    }


    /**
     * 抽象成背包问题，给定物资，问能不能用若干个包正好装下这些物资.
     * 难点在终止条件
     * numOfBags 代表前几个包
     * 这个递归转化为后面的DP
     */
    private boolean helperPackage(int numOfBags, int weight, int[] nums) {
        //没有物资，用前几个包肯定能装下
        if (weight == 0) return true;
        // weight < 0 开始漏了，例如nums={5},weight=3
        if (numOfBags == 0 || weight < 0) return false;
        return helperPackage(numOfBags - 1, weight - nums[numOfBags - 1], nums)
                || helperPackage(numOfBags - 1, weight, nums);

    }

    /**
     * 之前有其他问题每个包无限使用，这里包只能用依次，单纯的dp[weight]无法体现包的使用情况，已经不行了
     * dp[i][j]:重量j的物资用前i个包能否完成
     * 补充：DP中i经常代表前i个，而不是第i个，因为i表示索引无法表示空这个语义，
     *       i=0表示第0个，只能用-1，也就是要额外判断，用前i个没有这个烦恼。例如LCS问题中
     *       初始状态：
     * dp[i][0]：包括dp[0][0],没有物资，不管需要几个包都可以完成任务，所以都是true
     * dp[0][j>0]:没有包可以用，但是有物资要分配，无论如何完不成
     * 状态转移：
     * dp[i][j] :例如100物资前4个包，看前3个包能不能放，但是第4个包放不放未知。所以要分类
     * 图中反应的顺序：
     * 先看同一层里能不能找到，没有的话去上一层找，因此遍历顺序就是普通的矩阵遍历
     * follow-up: 改成问最少/最多需要几个包？转移的思路一样，拿或不拿最后一个包然后看看。
     */
    private boolean do01Package(int[] nums, int weight) {
        boolean[][] dp = new boolean[nums.length + 1][weight + 1];
        for (int j = 0; j <= weight; j++) {
            for (int i = 0; i <= nums.length; i++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    //dp[i][负数]应该等于false。例如一个包，能装5，weight等于3，是不能装的。
                    dp[i][j] = dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return dp[nums.length][weight];
    }

}
