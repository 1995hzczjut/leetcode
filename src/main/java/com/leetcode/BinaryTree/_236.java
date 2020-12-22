package com.leetcode.BinaryTree;



/**
 * 关键在于 lowestCommonAncestor 题目只保证pq都存在，但这对于完成递归是不够的，还要考虑不在的情况
 *
 * @author Zhancong Huang
 * @date 23:37 2018/12/28
 */
public class _236 {
    /**
     * 题目说PQ都存在，更重要的是PQ不在返回null，有一个在、一个不在返回在的那个。这是完成递归的关键，否则做不出
     * 终止情况遇到root节点为P或Q，或者一个都不是即空
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p、q正好有一个在root，直接返回
        if(root == null || p == root || q == root){
            return root;
        }
        //left！=null代表pq至少有一个root左边，=null，代表pq全在右边
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            //PQ在root不同的子树
            return root;
        }
        //pq在root的一侧
        return left != null ? left : right;
    }
}
