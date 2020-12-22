package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 19:50 2019/8/12
 */
public class _219 {

    /**
     * �������⣺2sum
     * ˳������У�������λ����ô��ô��������һ����˼·
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
