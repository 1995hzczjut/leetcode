package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _525 {

	/**
	 * ������Ҫ0��1����һ����
	 */
	public int findMaxLength(int[] nums) {
		//��0����1
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				nums[i]=-1;
		}
		Map<Integer,Integer> map = new HashMap<>();//�ͣ�����
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
