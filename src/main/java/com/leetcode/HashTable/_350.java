package com.leetcode.HashTable;

import java.util.*;
import java.util.stream.Stream;

/**
 * �����ɣ�
 * ��1��listתint[] ���飬�ؼ�Ҫ������ÿ��Integer->int
 * (2) ���������ʱ���õ��±꣬û����Arrays.stream.ֻ����Stream.iterate����ʼֵ��ÿ��ֵ��һ����Ϊ����foeach
 *
 * @author Zhancong Huang
 * @date 10:19 2019/6/18
 */
public class _350 {

    /**
     * �ص���follow-ups��
     * ��349�����𣬴�����Ҫ��pair,������Ҫmap����ִ�����
     * What if the given array is already sorted? How would you optimize your algorithm?
     * ˫ָ�룬����Merge set,���ڵ�ʱ��˫ָ��һ��
     * What if elements of nums2 are stored on disk, and the memory is limited
     * such that you cannot load all elements into the memory at once?
     * �Դ�����ֶ���֮�Ϳ����ˡ�
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
