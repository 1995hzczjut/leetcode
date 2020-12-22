package com.leetcode.HashTable;

import java.util.HashSet;

public class _202 {

	/**
	 *  or it loops endlessly in a cycle which does not include 1.
	 *  不是happy number 的话，会得到一个以前得到过的数，用Hashset简单解决了
	 */
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		while(set.add(n)){
			n = caculate(n);
			if(n == 1){
				return true;
			}
		}
		return false;
	}

	public int caculate(int n) { //可能是三位数的
		int a = 0; //余数
		int res = 0; //平方和
		while(n > 0){
			a = n%10;
			res += a*a;
			n = n/10;
		}
		
		return res;
	}

	public static void main(String[] args) {

	}

}
