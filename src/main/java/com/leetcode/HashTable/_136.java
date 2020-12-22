package com.leetcode.HashTable;

public class _136 {

	/**
	 * 异或运算的性质
	 * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

	= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

	= 0 ^ 0 ^ ..........^ 0 ^ N

	= N
	
	1. a ⊕ a = 0
	2. a ⊕ b = b ⊕ a
	3. a ⊕b ⊕ c = a ⊕ (b ⊕ c) = (a ⊕ b) ⊕ c;
	4. d = a ⊕ b ⊕ c 可以推出 a = d ⊕ b ⊕ c.
	5. a ⊕ b ⊕ a = b.
	
	 */
	 public int singleNumber(int[] nums) {
	        int res = 0;
	        for(int num : nums){
	            res = res^num;
	        }
	        return res;
	    }
	
	public static void main(String[] args) {

	}

}
