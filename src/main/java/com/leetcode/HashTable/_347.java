package com.leetcode.HashTable;

import java.util.*;

/**
 *  top K的变种，抽象出问题：
 *  怎么选出MAP的value的最大的几个？
 *  之前的做法是，拿出entreyset，对其排序。显然这道题不想那么做
 *  借鉴海量TOP K做法
 *
 * @author Zhancong Huang
 * @date 11:46 2019/9/30
 */
public class _347 {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>(256);
		for(int n: nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()){
			queue.offer(entry);
			if (queue.size() > k){
				queue.poll();
			}
		}
		List<Integer> res = new LinkedList<>();
		while (!queue.isEmpty()) {
			res.add(queue.poll().getKey());
		}
		return res;
	}


}
