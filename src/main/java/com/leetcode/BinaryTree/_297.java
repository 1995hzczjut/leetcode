package com.leetcode.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 449 105 106 都涉及序列化/反序列化
 * 449是BST，有排序信息，比较特殊，序列化不需要处理Null值，直接先序输出，参序列化按照前面的字符串逐个插入BST即可
 * 此题是一般二叉树，需要用特殊字符#保存NULL进序列化结果
 * 105 106也是一般序列化，也不能用#保存NULL，此时需要两种遍历方式的结果
 * 记住：先序+队列递归消费.队列递归时不用判空，但一定要处理#
 *
 * @author Zhancong Huang
 * @date 19:46 2019/7/19
 */
public class _297 {
    /**
     * 这里不能用栈遍历了，因为栈遍历不存NULL值，导致无法正确的加#
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(root.val)).append(" ");
        String left = serialize(root.left);
        String right = serialize(root.right);
        result.append(left).append(" ").append(right);
        return result.toString().trim();
    }


    /**
     * 反序列化，注意这个序列化结果用特殊字符代替了NULL节点
     * 之前没有代替的话，都是数字，还需要另外的一种遍历结果才能恢复
     * 这里方法也比较巧，用队列完成递归
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(" ")));
        return helper(queue);
    }

    /**
     * 队列里第一个节点保证是根节点，helper会把根节点后面的属于根节点代表的树的节点
     * 全部消费掉，并构成树
     */
    private TreeNode helper(Queue<String> queue) {
        //队列不可能空的
        String val = queue.poll();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        //helper会去消费第一个节点的树的所有节点，所以这里没有问题
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }

}
