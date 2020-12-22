package com.leetcode.String;

public class _67 {

	/**
	 * �����ö�Σ���Ҫ�����λ.���ҿ��Է���һ��ѭ����ɡ���ô����char �ӷ�����ĸ��Ҫ���ã�-'a' or -'0'
	 * Character.getNumericValue('1') Ҳ�ɴ���'1'
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
			if(char_a - '0' + char_b - '0' + carry == 3){ //charתint����ĸ�����г��÷���
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
