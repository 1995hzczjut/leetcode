package com.leetcode.HashTable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Zhancong Huang
 * @date 9:43 2019/8/13
 */
public class _380 {

    /**
     * 思路：
     * 用一个list,和一个存储List值到下标映射的Map，两者是互补的，list也可看成一个特殊的map。
     * 所以一个更新了另一个也要更新，这是【重点】！！！
     * 主要删除：是要删的地方跟末尾交换，然后干掉末尾。然后取随机的时候就很方便。
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
            //把末尾的数字移到idx
            list.set(idx, lastVal);
            map.put(lastVal, idx);
            //干掉末尾
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
