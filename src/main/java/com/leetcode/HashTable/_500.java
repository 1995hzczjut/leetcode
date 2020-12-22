package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _500 {

	/**
	 * 待抽象，大量重复代码
	 */
	public static String[] findWords(String[] words) {
		HashSet<Character> set1 = new HashSet<>();
		HashSet<Character> set2 = new HashSet<>();
		HashSet<Character> set3 = new HashSet<>();
		
		initByString(set1,"QWERTYUIOPqwertyuiop");
		initByString(set2,"ASDFGHJKLasdfghjkl");
		initByString(set3,"ZXCVBNMzxcvbnm");
		
		ArrayList<String> list = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < words.length; i++) {
			int flag1 = 1;
			int flag2 = 1;
			int flag3 = 1;
			for(char c : words[i].toCharArray()){
				if(!set1.contains(c)){
					flag1 = 0;
					
				}
				if(!set2.contains(c)){
					flag2 = 0;
					
				}
				if(!set3.contains(c)){
					flag3 = 0;
					
				}
				
			}
			if(flag1 == 1 || flag2 == 1 || flag3 == 1 ){
				list.add(words[i]);
			}
		}
		//list转字符串数组的正确方法
		
		return list.toArray(new String[list.size()]);
        
    }
	private static void initByString(HashSet<Character> set, String string) {
		for(int i = 0; i < string.length(); i++){
			set.add( string.charAt(i));
					
		}
		
	}
	public static void main(String[] args) {
		
	}

}
