package com.leetcode.String;

public class _383 {

	/**
	 * 
	 * ��������أ�һ��Ҫ�������ַ�����int[26]
	 */
	// is ransomNote the sub permutation of magazine?
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] magazines = new int[26];

		for (int i = 0; i < magazine.length(); i++) {
			magazines[magazine.charAt(i) - 'a']++;
		}
		// ���
		for (int i = 0; i < ransomNote.length(); ++i) {
			if (--magazines[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
