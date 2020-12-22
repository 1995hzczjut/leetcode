package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 19:50 2019/8/12
 */
public class _219 {

    /**
     * 背景问题：2sum
     * 顺序遍历中，找两个位置怎么怎么样，都是一样的思路
     *
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(265);
        for (int i = 0; i < nums.length; i++) {
            Integer r = map.put(nums[i], i);
            if (r != null && i - r <= k) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }

}
