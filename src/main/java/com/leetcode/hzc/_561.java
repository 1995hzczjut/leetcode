package com.leetcode.hzc;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _561 {

	/**
	 * @param args
	 */
	public static int func(int[] nums){
		Arrays.sort(nums);
		int sum = 0;
		for(int i = nums.length-2; i>=0; i=i-2){
			sum += nums[i];
		}
		
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(func(nums));
	}

}
