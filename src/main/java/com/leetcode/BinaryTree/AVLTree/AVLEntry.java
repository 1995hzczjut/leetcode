package com.leetcode.BinaryTree.AVLTree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Zhancong Huang
 * @date 10:29 2018/10/8
 */
public class AVLEntry<K, V> implements Map.Entry<K, V> {
    K key;
    V value;
    AVLEntry<K, V> left;
    AVLEntry<K, V> right;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    public String toString() {
        return "AVLEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public AVLEntry(K key, V value, AVLEntry<K, V> left, AVLEntry<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public AVLEntry(K key, V value) {

        this.key = key;
        this.value = value;
    }

    public AVLEntry(K key) {

        this.key = key;
    }
}
