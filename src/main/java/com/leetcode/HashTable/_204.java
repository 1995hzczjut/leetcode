package com.leetcode.HashTable;

/**
 * �������ֵ����⣬ҲҪ��ס��
 *
 * @author Zhancong Huang
 * @date 15:37 2019/8/12
 */
public class _204 {

	/**
	 * 0��1��������������boolean���飬���δ���2��3��4��5����������
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
