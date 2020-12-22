package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用addfirst
 *
 * @author Zhancong Huang
 * @date 20:03 2019/4/16
 */
public class p3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode cur = listNode;
        while (cur != null){
            result.add(cur.val);
            cur = cur.next;
        }
        int i = 0, j = result.size() - 1;
        while (i < j){
            int tmp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, tmp);
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(printListFromTailToHead(l1));
    }
}
