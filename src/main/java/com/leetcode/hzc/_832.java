package com.leetcode.hzc;

public class _832 {

	/**
	 * @param args
	 */
	
	public static void func(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			flip(arr[i]);
			invert(arr[i]);
		}
		
	}
	private static void invert(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++){
			int temp = 0;
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
	}
	private static void flip(int[] is) {
		for (int i = 0; i < is.length; i++) {
			is[i] = 1 - is[i];
		}
	}
	public static void main(String[] args) {
		int[][] a = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		func(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}

}
