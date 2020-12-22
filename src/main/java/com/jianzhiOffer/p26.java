package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

/**
 *
 * @author Zhancong Huang
 * @date 13:41 2019/4/21
 */
public class p26 {


    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode right = Convert(pRootOfTree.right);
        if (left != null) {
            TreeNode p = left;
            //这里用p!=null就找不到p的前一个了，所以只能用p.right != null
            while (p.right != null){
                p = p.right;
            }
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //注意left null。left等于Null应该返回原始起点
        return left == null ? pRootOfTree : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode r1 = new TreeNode(6);
        TreeNode r2 = new TreeNode(14);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(8);
        TreeNode r5 = new TreeNode(12);
        TreeNode r6 = new TreeNode(16);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        TreeNode res = new p26().Convert(r1);
        System.err.println(res.val);
    }
}
