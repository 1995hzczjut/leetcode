package com.leetcode.HashTable;

import java.util.*;
import java.util.stream.Stream;

/**
 * 流技巧：
 * （1）list转int[] 数组，关键要把流的每个Integer->int
 * (2) 遍历数组的时候拿到下标，没法用Arrays.stream.只能用Stream.iterate（初始值，每次值加一的行为）。foeach
 *
 * @author Zhancong Huang
 * @date 10:19 2019/6/18
 */
public class _350 {

    /**
     * 重点是follow-ups。
     * 跟349的区别，此题需要找pair,所以需要map存出现次数。
     * What if the given array is already sorted? How would you optimize your algorithm?
     * 双指针，类似Merge set,等于的时候双指针一起动
     * What if elements of nums2 are stored on disk, and the memory is limited
     * such that you cannot load all elements into the memory at once?
     * 对大数组分而治之就可以了。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(256);
        Arrays.stream(nums1).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        List<Integer> res = new LinkedList<>();
        Stream.iterate(0, i -> i + 1).limit(nums2.length).forEach(i -> {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        });
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }

}
