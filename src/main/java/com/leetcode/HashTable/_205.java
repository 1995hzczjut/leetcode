package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _205 {

    /**
     * 290一样的，略
     * paper title 指针同时遍历，存每一对char.
     * 后面检查的时候有坑，新的一对char，key在map的话，value不在肯定不行。
     * 容易漏的情况是，key不在，value在。例如ae, ii。
     * 也就是说a-i是唯一映射，不允许其他字符指向i，也不允许a指向其他字符
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (!map.get(a).equals(b)) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
