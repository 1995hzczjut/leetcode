package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.List;

public class _690 {

	/**
	 * DFS，提交的时候多了个}找了半天错。。。。
	 */
	public static class Employee {
	    
	    public int id;
	    
	    public int importance;
	    
	    public List<Integer> subordinates;
	};
	
	 public static int getImportance(List<Employee> employees, int id) {
		HashMap<Integer,Employee> map = new HashMap<>();
		for(Employee e : employees){
			map.put(e.id, e);
		}
		return dfs(map,id);
	        
	    }
	
	public static int dfs(HashMap<Integer,Employee> map, int id) {
		int res = 0;
		for(int subId : map.get(id).subordinates){
			res += dfs(map,subId);
		}
		
		
		return res;
	}

	public static void main(String[] args) {

	}

}
