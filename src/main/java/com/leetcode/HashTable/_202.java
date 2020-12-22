package com.leetcode.HashTable;

import java.util.HashSet;

public class _202 {

	/**
	 *  or it loops endlessly in a cycle which does not include 1.
	 *  ����happy number �Ļ�����õ�һ����ǰ�õ�����������Hashset�򵥽����
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

	public int caculate(int n) { //��������λ����
		int a = 0; //����
		int res = 0; //ƽ����
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
