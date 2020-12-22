package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _594 {

	/**
	 * 给你一个数组，找出一个子序列，这个序列中最大跟最小的数差值为1
	 */
public int findLHS(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
        	map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i])+1 : 1);
        }
        int res = 0;int max = 0;
        for(int key: map.keySet()){
        	if(map.containsKey(key+1)){
        		res = map.get(key)+map.get(key+1);
        		max = res>max ? res : max;
        	}
        }
        return max;
    }
	
	public static void main(String[] args) {

	}

}
