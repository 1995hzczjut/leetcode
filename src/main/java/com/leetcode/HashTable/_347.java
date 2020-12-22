package com.leetcode.HashTable;

import java.util.*;

/**
 *  top K�ı��֣���������⣺
 *  ��ôѡ��MAP��value�����ļ�����
 *  ֮ǰ�������ǣ��ó�entreyset������������Ȼ����ⲻ����ô��
 *  �������TOP K����
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
