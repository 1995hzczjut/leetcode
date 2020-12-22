package com.jianzhiOffer;

/**
 * @author Zhancong Huang
 * @date 22:14 2019/4/28
 */


public class p57 {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * pNode不是root，是root的话非常简单,直接返回Null
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;
        //有右子树，那么下一个节点是右子树的左下节点
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        //没有右子树，代表pNode代表的树已经遍历完了。这里又分两种情况：
        //（1）pNode代表的树 是它父节点的 左子树：直接返回pNode.next
        //（2）pNode代表的树 是它父节点的 右子树：这一步最难，此时代表pNode的父节点代表的树也遍历完了。应该递归处理
        // 直到一个节点，位于它父节点的左边，然后返回父节点。找不到证明遍历完了，返回NULL。
        //其实（1）是 （2）的特例
        TreeLinkNode cur = pNode, pre = cur.next;
        while (pre != null && pre.left != cur) {
            cur = pre;
            pre = cur.next;
        }
        return pre;
    }
}
