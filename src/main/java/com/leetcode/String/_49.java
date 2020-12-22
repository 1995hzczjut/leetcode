package com.leetcode.String;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 21:12 2018/10/30
 */
public class _49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            if (map.containsKey(encode(s))) {
                map.get(encode(s)).add(s);
            } else {
                map.put(encode(s), new ArrayList<String>());
                map.get(encode(s)).add(s);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }

    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            arr[str.charAt(i) - 'a']++;

        }
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(str);
    }


}
