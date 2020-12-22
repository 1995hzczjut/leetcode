package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 小错误很多,最容易忘得是链表动了.map不动
 *
 * @author Zhancong Huang
 * @date 21:37 2019/8/1
 */
public class _146 {
    static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    static class LRUCache {

        Map<Integer, Node> map = new HashMap<>(256);
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        final int MAX_SIZE;

        public LRUCache(int capacity) {
            MAX_SIZE = capacity;
            //开始忘记写了
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node retNode = map.get(key);
            delete(retNode);
            setTail(retNode);
            return retNode.value;
        }


        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node oldNode = map.get(key);
                oldNode.value = value;
                delete(oldNode);
                setTail(oldNode);
            } else {
                if (map.size() == MAX_SIZE) {
                    Node removingNode = head.next;
                    delete(removingNode);
                    map.remove(removingNode.key);
                }
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                setTail(newNode);
            }
        }

        /**
         * 越靠近tail代表越新的节点，这个方法把指定节点放在最新的地方
         */
        private void setTail(Node newNode) {
            Node oldNode = tail.prev;
            oldNode.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            newNode.prev = oldNode;
        }

        /**
         * 在链表中删除给定节点
         */
        private void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}
