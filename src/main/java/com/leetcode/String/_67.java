package com.leetcode.String;

public class _67 {

	/**
	 * 看到好多次，主要处理进位.而且可以放在一个循环完成。怎么处理char 加法，字母中要常用：-'a' or -'0'
	 * Character.getNumericValue('1') 也可处理'1'
	 */
	public static String addBinary(String a, String b) {
		char[] arr_a = a.toCharArray();
		char[] arr_b = b.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = arr_a.length-1;
		int j = arr_b.length-1;
		int carry = 0;
		while(i >= 0 || j >=0 || carry == 1){
			char char_a = i >= 0 ? arr_a[i] : '0';
			char char_b = j >= 0 ? arr_b[j] : '0';
			if(char_a - '0' + char_b - '0' + carry == 3){ //char转int，字母处理中常用方法
				sb.insert(0, "1");
				carry = 1;
			}else if(char_a - '0' + char_b - '0' + carry == 2){
				sb.insert(0, "0");
				carry = 1;
			}else if(char_a - '0' + char_b - '0' + carry == 1){
				sb.insert(0, "1");
				carry = 0;
			}else{
				sb.insert(0, "0");
				carry = 0;
			}
			i--;
			j--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11","1"));
		//System.out.println('1'+'1');
		//System.out.println('1'+1);
		//System.out.println(Character.getNumericValue('1'));
	}

}
