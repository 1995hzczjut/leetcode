package com.leetcode.BinaryTree;

/**
 * "1(2(4(()())())3(()()))" 出现这个结果要知道为什么》怎么解决？
 *
 * @author Zhancong Huang
 * @date 23:55 2018/12/19
 */
public class _606 {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return String.valueOf(t.val);
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        sb.append("(");
        sb.append(tree2str(t.left));
        sb.append(")");

        if (t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
