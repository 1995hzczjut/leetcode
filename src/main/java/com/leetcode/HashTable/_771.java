package com.leetcode.HashTable;

public class _771 {

	/**
	 * @param
	 */
	 public static int numJewelsInStones(String J, String S) {
	  
		 int res = 0;
		 for (int i = 0; i < S.length(); i++) {
			if(J.contains(String.valueOf(S.charAt(i)))){
				res++;
			}
			
		}
		 return  res;
		 
	 }
	
	public static void main(String[] args) {

	}

}
