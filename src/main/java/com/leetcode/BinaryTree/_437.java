package com.leetcode.BinaryTree;

import com.leetcode.HashTable._560;

import java.util.HashMap;
import java.util.Map;

/**
 * 依赖一个前置问题，给一个数组nums，一个target，找数组中连续的子数组和等于target的个数？
 * O（N） 遍历一次，在线处理就可以解决。一定要注意初始化一个（0，1）
 *
 * @author Zhancong Huang
 * @date 22:26 2018/12/13
 * @see _560
 */
public class _437 {

    /**
     * 回顾560：计算累加和，不断的回头看。
     * 这里也一样，把树看成线性的，那么只能用先序遍历，
     * 具体写法还是参考combination
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        Map<Integer, Integer> map = new HashMap<>(256);
        map.put(0, 1);
        helper(result, root, root.val, map, sum);
        return result[0];
    }


    /**
     * 这题只能用先序，遍历到一个节点，map里放的正好是从root到这个点的路径
     * 一个子树结束，切换到另一边的时候，这个节点对应的MAP的记录要全部删掉，类似combination里的tmp数组
     */
    private void helper(int[] result, TreeNode root, int prefix, Map<Integer, Integer> map, int target){
        result[0] += map.getOrDefault(prefix - target , 0);
        map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        if (root.left != null){
            helper(result, root.left, prefix + root.left.val, map, target);
        }
        if (root.right != null){
            helper(result, root.right, prefix + root.right.val, map, target);
        }
        //难点：root这个子树OK了，切换到跟他同级的子树，那么这个点再也走不到，所以要再MAP撤销
        map.put(prefix, map.get(prefix) - 1);
    }


}
