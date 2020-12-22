package com.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 跟105一样，优化点杂鱼105要反复通过遍历找一个节点的下标，不如直接建立map。
 *
 * @author Zhancong Huang
 * @date 21:14 2019/7/18
 */
public class _106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return dfs(map, inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    //map记得参数里就加泛型，不然后面要强转，麻烦。
    //扣边界还是带入最快
    private static TreeNode dfs(Map<Integer, Integer> map, int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        System.out.println(inLeft + "," + inRight + " ; " + postLeft + "," + postRight);
        if (inLeft > inRight || postLeft > postRight) return null;
        TreeNode root = new TreeNode(postorder[postRight]);
        int index = map.get(root.val);
        root.left = dfs(map, inorder, postorder, inLeft, index - 1, postLeft, postLeft + index - inLeft - 1);
        root.right = dfs(map, inorder, postorder, index + 1, inRight, postLeft + index - inLeft, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        buildTree(inorder, postorder);
    }

}
