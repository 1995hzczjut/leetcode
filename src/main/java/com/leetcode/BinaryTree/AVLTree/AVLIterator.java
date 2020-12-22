package com.leetcode.BinaryTree.AVLTree;

import java.util.Iterator;
import java.util.Stack;

/**
 *  类似lc173.注意这里的泛型用法
 *  迭代器是去迭代集合里的对象，map类都是entry,树是TreeNode
 * @author Zhancong Huang
 * @date 11:10 2018/10/8
 */
public class AVLIterator<K, V> implements Iterator<AVLEntry<K, V>> {

    private Stack<AVLEntry<K, V>> stack = new Stack<>();

    private AVLEntry<K, V> cur;

    public AVLIterator(AVLEntry<K, V> root) {
        this.cur = root;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    @Override
    public AVLEntry<K, V> next() {
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        AVLEntry<K, V> entry = stack.pop();
        cur = entry.right;
        return entry;
    }


}
