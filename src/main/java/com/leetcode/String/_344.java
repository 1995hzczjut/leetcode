package com.leetcode.String;

public class _344 {


	//Í·Î²½»»»
	public String reverseString(String s) {
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length/2; ++i){
			swap(arr, i ,arr.length-i-1);
		}
		return new String(arr);
	}

	public void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	public static void main(String[] args) {
		
	}

}
