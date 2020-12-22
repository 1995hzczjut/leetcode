package com.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zhancong Huang
 * @date 16:12 2019/8/23
 */
public class p54 {


    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        sb.append(ch);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public char FirstAppearingOnce() {
        char[] chars = sb.toString().toCharArray();
        for(char c : chars){
            if (map.get(c) == 1) return c;
        }
        return '#';
    }
}
