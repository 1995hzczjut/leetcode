package com.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652题目很像，思路也一样。先序遍历，从下往上审查重复次数/
 * 千万不能写成单个计算所有节点的和
 * 关键问题：怎么找到一串数字中出现次数最多的所有的数字？
 * 思路：建立MAP key=num, value=该和出现的次数。循环加入MAP的过程中，记录最多的出现次数
 * 然后再遍历MAP
 *
 * @author Zhancong Huang
 * @date 18:47 2018/12/29
 */
public class _508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>(256);
        int[] max = new int[1];
        helper(root, map, max);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max[0]) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int helper(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) return 0;
        int sum = helper(root.left, map, max) + helper(root.right, map, max) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max[0] = Integer.max(max[0], map.get(sum));
        return sum;
    }
}
