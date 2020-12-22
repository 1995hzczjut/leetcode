package com.leetcode.collectionsTest.HashMapTest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 测试LHM
 *
 * @author Zhancong Huang
 * @date 18:37 2018/10/11
 */
public class LinkedHashMapTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            linkedHashMap.put(i, i + "");
        }
//        for (int i = 0; i < 5; i++) {
//            linkedHashMap.put(i, "newValue:  " + i);
//        }

        for (int i = 0; i < 5; i++) {
            linkedHashMap.get(i);
        }
        for (int i = 11; i < 20; i++) {
            linkedHashMap.put(i, i + "");
        }

        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
