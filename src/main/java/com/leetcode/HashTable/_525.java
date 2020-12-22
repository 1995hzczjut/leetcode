package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _525 {

	/**
	 * 题意是要0和1个数一样，
	 */
	public int findMaxLength(int[] nums) {
		//把0换成1
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				nums[i]=-1;
		}
		Map<Integer,Integer> map = new HashMap<>();//和，索引
		map.put(0,-1);
		int  max = 0,sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum)){
				max = Math.max(max, i-map.get(sum));
				continue;
			}
			map.put(sum, i);
		}
		return max;
		
	}

	public static void main(String[] args) {

	}

}
