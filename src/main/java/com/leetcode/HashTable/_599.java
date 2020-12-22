package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599 {

	//��������һ��ֵ��Զ���Ž�ȥ��
	public String[] findRestaurant1(String[] list1, String[] list2) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		//String[] ans = new String[1];
		List<String> list = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0; i < list1.length; i++){
			map.put(list1[i], i);
		}
		for(int i = 0; i < list2.length; i++){
			if(map.containsKey(list2[i])){
				res = map.get(list2[i])+i;
				if(res<=min){
					min = res;
					//ans[0] = list2[i];
					list.add(list2[i]);
				}
			}
		}
		String[] ans = new String[list.size()];
		String[] a = list.toArray(ans);
		 int min_sum = Integer.MAX_VALUE, sum;
		return a;
	}
	
	//�Ľ�.����и�С�ģ�һ��Ҫ��֮ǰ������ա�˼·��Ҫ��
	public String[] findRestaurant2(String[] list1, String[] list2) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		//String[] ans = new String[1];
		List<String> list = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0; i < list1.length; i++){
			map.put(list1[i], i);
		}
		for(int i = 0; i < list2.length; i++){
			if(map.containsKey(list2[i])){
				res = map.get(list2[i])+i;
				if(res<min){
					list.clear(); //��clear
					min = res;
					//ans[0] = list2[i];
					list.add(list2[i]);
				}else if(res == min){
					list.add(list2[i]);
				}
			}
		}
		String[] ans = new String[list.size()];
		String[] a = list.toArray(ans);
		
		return a;
	}
	
	public static void main(String[] args) {

	}

}
