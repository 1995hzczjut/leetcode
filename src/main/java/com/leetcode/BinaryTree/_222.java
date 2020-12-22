package com.leetcode.BinaryTree;

/**
 * 计算完全二叉树的个数，比较巧，利用树的最左边一路的高度
 *
 * @author Zhancong Huang
 * @date 12:49 2018/11/8
 */
public class _222 {

    /**
     * -1 - indexed
     * 满二叉树，高度只跟左子树有关
     *
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + height(root.left);
    }

    /**
     * 递归。做法就是验证左右子树那个是完全二叉树
     * 一： 右子树左边一路的高度跟root代表的树的高度差1，代表左子树必然是满的，右子树递归计算即可
     * 二：不差1，由于是完全二叉树，所以只能差2，即右子树满了，左子树递归计算。
     */
    public int countNodes1(TreeNode root) {
        int h = height(root);
        int numerOfChildAndRoot = 0;
        int rest = 0;

        if (h == -1) {
            return 0;
        }
        if (height(root.right) == (h - 1)) {
            //左子树必满
            //计算root和它左字树的数量
            numerOfChildAndRoot = 1 << h;
            rest = countNodes1(root.right);
        } else {
            //左子树不一定满，此时右子树一定满，只不过少了一层
            //计算root和它右字树的数量
            numerOfChildAndRoot = 1 << (h - 1);
            rest = countNodes1(root.left);
        }
        return numerOfChildAndRoot + rest;
    }

    /**
     * 改成递归。跟栈遍历一样，while循环看成递归的开始
     */
    public int countNodes(TreeNode root) {
        int h = height(root);
        int result = 0;

        while (root != null) {
            if (height(root.right) == (h - 1)) {
                result += 1 << h;
                //自己移动指针代替之前函数栈帧的跳转
                root = root.right;
            } else {
                result += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
