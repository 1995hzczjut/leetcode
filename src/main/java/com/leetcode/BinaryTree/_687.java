package com.leetcode.BinaryTree;

/**
 * 递归里套递归是最慢的
 *
 * @author Zhancong Huang
 * @date 22:26 2018/12/25
 */
public class _687 {

    /**
     * 参考543.所有经过root的path中找最大值。效率明显低。
     */
    public int longestUnivaluePath1(com.leetcode.dfs.TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        int max = Math.max(left + right, Math.max(longestUnivaluePath1(root.left), longestUnivaluePath1(root.right)));
        return max;
    }

    public int helper(com.leetcode.dfs.TreeNode root, int val) {
        if (root == null || root.val != val) return 0;
        return 1 + Math.max(helper(root.left, val), helper(root.right, val));
    }


    /**
     * 一次递归,比上面快了正好一半。还是老套路：假设longestUnivaluePath2 root的两个节点都拿到结果了，怎么组织最终的答案？
     * 最终的结果备选应该有三个，除了上面的两个子树的结果，可能还有经过root的。所以递归的返回要两个值
     */
    public int longestUnivaluePath2(TreeNode root) {
        int[] result = helper1(root);
        return result[1];
    }

    /**
     * lpath，rpath 算的是节点数，例如3个节点的数，root.left的lpath正好是1
     * 而经过root的 unipath真好lpath+rpath
     *
     * @return {经过root的最长单边univalue path，不一定经过root的最长univalue path}
     */
    private int[] helper1(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftResult = helper1(root.left);
        int[] rightResult = helper1(root.right);
        int[] result = new int[2];
        //一开始忘记验证了，经过子节点的单边最长不能直接加1作为root节点的单边最长
        //如果两个节点值不一样，直接返回0。
        int lpath = root.left != null && root.val == root.left.val ? leftResult[0] : 0;
        int rpath = root.right != null && root.val == root.right.val ? rightResult[0] : 0;


        result[0] = 1 + Math.max(lpath, rpath);
        result[1] = Math.max(lpath + rpath, Math.max(leftResult[1], rightResult[1]));
        return result;
    }
}
