package com.jianzhiOffer;


/**
 * NPE一定要注意。主要cur指向最后一个结点；random指向空
 * while (cur != null) {
 * 不需要dummy节点，pHead始终指向原始起点，程序的cur节点始终用pHead初始化
 *
 * @author Zhancong Huang
 * @date 13:07 2019/4/21
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class p25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //
        RandomListNode cur = pHead;
        //一开始写成next = cur.next,用next去遍历，这样会漏掉最后一个结点。
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        RandomListNode res = pHead.next;
        //设置random,并恢复原链表
        cur = pHead;
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        cur = pHead;
        //怕搞混可以用三个变量cur next copy
        while (cur != null) {
            RandomListNode next = cur.next.next;
            //这个NPE极难发现，cur再最后一个结点，next可能为空，
            cur.next.next = next != null ? next.next : null;
            cur.next = next;
            cur = next;
        }
        return res;
    }
}
