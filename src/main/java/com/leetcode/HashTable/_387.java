package com.leetcode.HashTable;

public class _387 {

	/**
	 * 字符串问题的常见技巧。统计每个字母的出现次数，不需要map.类似bitmap的思想。
	 * 统计完再按源字符串chararray从左向右查。
	 */
	public static int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
        	letters[s.charAt(i) - 'a']++;
		}
        for(int i = 0; i < s.length(); i++){
        	if(letters[s.charAt(i) - 'a'] == 1)
        		return i;
        }
		return -1;
		
    }
	
	public static void main(String[] args) {
		System.out.println(firstUniqChar("lzalll"));
	}

}
