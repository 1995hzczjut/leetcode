package com.leetcode.HashTable;

/**
 * 经常出现的问题，也要记住。
 *
 * @author Zhancong Huang
 * @date 15:37 2019/8/12
 */
public class _204 {

	/**
	 * 0，1都不算素数。建boolean数组，依次处理2，3，4，5倍数的数字
	 */
	public int countPrimes(int n) {
		boolean[] arr = new boolean[n];
		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!arr[i]){
				res++;
				int j = 2;
				while (i * j <  n){
					arr[i * (j++)] = true;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
