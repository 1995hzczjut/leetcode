package com.leetcode.math;

public class _415 {

    /**
     * LC67一样的，链表问题里也有相似的。重点在于 while (index1 >= 0 || index2 >= 0 || carry == 1) 非常巧妙
     */
    public static String addStrings1(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (index1 >= 0 || index2 >= 0 || carry == 1) {
            int n1 = index1 >= 0 ? (num1.charAt(index1--) - '0') : 0;
            int n2 = index2 >= 0 ? (num2.charAt(index2--) - '0') : 0;
            int n = n1 + n2 + carry;
            carry = n / 10;
            n = n % 10;
            sb.insert(0, n);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings1("9", "99"));
    }

}
