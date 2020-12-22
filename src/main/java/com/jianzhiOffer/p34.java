package com.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * charmap的应用
 *
 * @author Zhancong Huang
 * @date 13:52 2019/4/22
 */
public class p34 {
    public int FirstNotRepeatingChar(String str) {
        //有大小写，26位不够了。直接map了
        Map<Character, Integer> charMap = new HashMap<>(256);
        for (char c : str.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (charMap.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
