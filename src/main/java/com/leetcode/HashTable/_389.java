package com.leetcode.HashTable;

public class _389 {

	/**
	 *
	 */
	 public char findTheDifference(String s, String t) {
	        //s�̣�t��
		 int n = t.length();
		 char c = t.charAt(n-1); //�������һ��
		 for(int i = 0; i < n-1; i++){
			 c = (char) ((c^s.charAt(i))^t.charAt(i));  //��ǿת������
			 //c ^= s.charAt(i);
		 }
		 return c;
	    }
	
	
	public static void main(String[] args) {

	}

}
