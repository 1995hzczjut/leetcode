package com.leetcode.linkedlist;

/**
 * 坑就在NPE，例如random=null,还要random.next,等等
 * 总之写X.X 就要思考会不会出现NPE
 *
 * @author Zhancong Huang
 * @date 23:22 2019/4/8
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

/**
 * 这题的最后结点的空间应该不算总的空间复杂度的。
 */
public class _138 {
    public Node copyRandomList(Node head) {
        //构造拷贝
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            //注意构造方法
            //新节点next指向cur.nextWWWWWWWWWWWW
            cur.next = new Node(cur.val, next, null);
            cur = next;
        }
        //确定随机指针    .
        cur = head;
        while (cur != null){
            //NPE
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        //拆开
        cur = head;
        Node res = cur != null ? cur.next : null;
        while (cur != null){
            //next可能为空
            Node next = cur.next.next;
            cur.next.next = next == null ? null : next.next;
            cur = cur.next = next;
        }
        return res;
    }
}
