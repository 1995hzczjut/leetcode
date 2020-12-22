package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 之前很多类似的，例如输出最右边的PATH
 * 两个思路：1）BFS 2)DFS，引入depth变量+先序
 *
 * @author Zhancong Huang
 * @date 19:53 2019/7/19
 */
public class _513 {

    //利用先序遍历。要求的结点一定是中序遍历到达最下一层，第一次访问到的结点
    //一定有两个变量。res:记录最终的答案，第一次到达某一层时去更新，否则不更新
    //h:记录访问这个结点之前到达的深度。如果小于等于【注意这个等于】之前的h,说明没必要更新res
    public static int findBottomLeftValue(TreeNode root) {
        return helper1(root, 1, new int[]{0, 0}); //new字不要忘了
    }

    /*
     * 利用DFS+先序遍历
     * root:这次调用函数访问的结点
     * depth:该结点所在的高度
     * res[0]:当前保存的全局答案
     * res[1]:访问该结点之前达到过的最大高度
     *这种更新全局变量的问题，可以在外面利用成员变量，也可以自己在函数里带一个数组
     * */
    public static int helper1(TreeNode root, int depth, int[] res) {
        if (res[1] < depth) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null) helper1(root.left, depth + 1, res);
        if (root.right != null) helper1(root.right, depth + 1, res);
        return res[0];
    }

    /*
     * BFS
     *利用队列实现树的层级遍历。保存每层第一次遍历到的结点。
     * */
    public static int findBottomLeftValue1(TreeNode root) {
        if (root == null) return 0;
        //这行也体现了接口像一种规范。linkedlist实现了queue接口，表示它接受队列这个接口的约定，具有add，pull的功能。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        //每次while循环开始，queue表示一层的结点

        while (!queue.isEmpty()) {  //写成queue != null  .无限循环
            //for (int i = 0; i < queue.size(); ++i) {         严重错误。也是集合尽量用迭代器的原因。size会变。
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                //第一次该层第一个结点
                TreeNode node = queue.poll();
                if (i == 0) res = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode raw2_1 = new TreeNode(2);
        TreeNode raw2_2 = new TreeNode(3);
        TreeNode raw3_1 = new TreeNode(4);
        TreeNode raw3_2 = new TreeNode(5);
        TreeNode raw3_3 = new TreeNode(6);
        TreeNode raw4_1 = new TreeNode(7);
        root.left = raw2_1;
        root.right = raw2_2;
        raw2_1.left = raw3_1;
        raw2_2.left = raw3_2;
        raw2_2.right = raw3_3;
        raw3_2.left = raw4_1;
        System.out.println(findBottomLeftValue1(root));
    }
}
