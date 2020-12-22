package com.leetcode.HashTable;

import java.util.HashSet;

public class _575 {

	/**
	 * @param args
	 */
	public static int distributeCandies(int[] candies) {
        HashSet<Integer> hashset = new HashSet<>();
        for (Integer i : candies) {
			if(!hashset.contains(i)){
				hashset.add(i);
			}
		}
        return Math.min(hashset.size(),candies.length/2);
    }
	
	public static void main(String[] args) {

	}

}
