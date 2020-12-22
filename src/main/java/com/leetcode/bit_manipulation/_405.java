package com.leetcode.bit_manipulation;

/**
 * hashmap里也是这么算的，难在负数怎么处理
 *
 * @author Zhancong Huang
 * @date 23:32 2019/6/29
 */
public class _405 {
    public static String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        //while (num > 0) {  负数没法算
        while (num != 0) {
            sb.insert(0, map[num & 15]);
            num = (num >>> 4);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
}
