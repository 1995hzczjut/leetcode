package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 10:18 2019/8/11
 */
public class _1 {

	/**
	 * 空间时间的权衡优先时间
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>(256);
		for (int i = 0; i < nums.length; i++) {
			int remain = target - nums[i];
			if(map.containsKey(remain)){
				return new int[]{i,map.get(remain)};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException();
	}


}
