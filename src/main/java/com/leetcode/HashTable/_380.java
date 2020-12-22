package com.leetcode.HashTable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Zhancong Huang
 * @date 9:43 2019/8/13
 */
public class _380 {

    /**
     * ˼·��
     * ��һ��list,��һ���洢Listֵ���±�ӳ���Map�������ǻ����ģ�listҲ�ɿ���һ�������map��
     * ����һ����������һ��ҲҪ���£����ǡ��ص㡿������
     * ��Ҫɾ������Ҫɾ�ĵط���ĩβ������Ȼ��ɵ�ĩβ��Ȼ��ȡ�����ʱ��ͺܷ��㡣
     */
    static class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>(256);
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int idx = map.get(val);
            int lastVal = list.get(list.size() - 1);
            int lastIdx = list.size() - 1;
            //��ĩβ�������Ƶ�idx
            list.set(idx, lastVal);
            map.put(lastVal, idx);
            //�ɵ�ĩβ
            list.remove(lastIdx);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
