package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _447 {

	/**
	 * @param args
	 */
	 public static int numberOfBoomerangs(int[][] points) {
	      int res = 0;
	      Map<Integer,Integer> hashMap = new HashMap<>();
	      for(int i = 0; i < points.length; i++){ //题意中的i
	    	  for(int j =0; j < points.length; j++){
	    		  int d = distance(points[i],points[j]);
	    		  hashMap.put(d, hashMap.containsKey(d) ? hashMap.get(d)+1 : 1);
	    	  }
	    	  for(int val : hashMap.values()){
	    		  res += val*(val-1);
	    	  }
	    	  hashMap.clear();
	      }
	      return res;
	 }
	 
	 
	
	private static int distance(int[] i, int[] j) {
		int dx = i[0] - j[0];
		int dy = i[1] - j[1];
		return dx*dx + dy*dy;
	}



	



	public static void main(String[] args) {

	}

}
