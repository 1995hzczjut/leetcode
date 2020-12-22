package com.leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  N叉树的最大深度
 * @author Zhancong Huang
 * @date 22:53 2018/12/18
 */
public class _559 {

    public int helper1(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        //可以插Null，底层重新包装了一下。认为queue不为空了所以要先验证root==null?
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            Node tmpNode = null;
            for (int i = 0; i < size; i++) {
                tmpNode = queue.poll();
                for (Node node : tmpNode.children){
                    queue.offer(node);
                }
            }
            result++;
        }
        return result;
    }

    public int helper2(Node root) {
        if(root == null){
            return 0;
        }
        int result = 0;
        //递归，寻找f(n-1)
        for (Node node : root.children){
            result = Integer.max(result, helper2(node));
        }
        return result+1;
    }

}
