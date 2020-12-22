package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2sum进化，这题小心一个数到下标0的和正好满足条件，要求我们先在map里存一个0，1对
 * 问题转化：O（N）代价算出数组的累加和，然后找所有的pair，满足两者之差等于k
 * 如果单个累加和正好等于k,也是满足条件的
 *
 * @author Zhancong Huang
 * @date 10:24 2019/7/16
 */
public class _560 {

    /**
     * 给定一个数组，O（N）时间内找到有多少个子数组和等于target ,子数组长度不要求
     * 思路：
     * 用i遍历，每个位置保存0到当前数字的和，存入map，key为这个和，value为出现的次数
     * 在i处，可以在map找这样的key，key+target正好等于当前数字对应的和。
     * 这个问题也是2sum问题进化而来的，之前两个数字和怎么样，现在两个数字到下标0的和之间的差值怎么样
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(256);
        //易漏.sum正好等于k,要去找前面sum=0的出现次数
        map.put(0, 1);
        //代表[0,i]的数组和
        int subSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //在线处理，遍历到i看i之前的闭区间
            subSum += nums[i];
            //注意此时map保证存的东西在i之前。可能出现[0,i]自己的和等于k，所以前面要put 0,1
            result += map.getOrDefault(subSum - k, 0);
            //存入当前subSum
            map.put(subSum, map.getOrDefault(subSum, 0) + 1);
        }
        return result;
    }
}
