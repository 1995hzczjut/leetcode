package com.leetcode.dp;


/**
 *
 * @author Zhancong Huang
 * @date 14:33 2019/4/13
 */
public class _413 {

	/**
	 * The function should return the number of arithmetic slices in the array A.
	 * slice ����subArray.����Ȼ�뵽��iΪ�׵�DP����
	 */
	public int numberOfArithmeticSlices(int[] A) {
		if (A.length < 3) return 0;
		int[] dp = new int[A.length];
		int res = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
				//iҪ��i-1��һ��������i-2,i-1,i
				dp[i] = dp[i - 1] + 1;
				res += dp[i];
			}
		}
		return res;
	}


	public static void main(String[] args) {

	}

}
