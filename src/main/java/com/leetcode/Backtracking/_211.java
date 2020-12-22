package com.leetcode.Backtracking;

import com.leetcode.BinaryTree.Trie.TrieTree;


/**
 * 范了数组引用的错误。search通配符的做法比较巧
 *
 * @author Zhancong Huang
 * @date 12:48 2019/5/29
 * @see TrieTree
 */
public class _211 {

    static class TrieNode {
        public int end = 0;
        public TrieNode[] nexts = new TrieNode[26];

    }

    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public _211() {

    }

//    错误代码nextNode = new TrieNode();，只是把引用重新指向一块内存。原数组没有任何改变
//    public void addWord(String word) {
//        TrieNode cur = root;
//        char[] chars = word.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            TrieNode nextNode = cur.nexts[chars[i] - 'a'];
//            if (nextNode == null) {
//                nextNode = new TrieNode();
//            }
//            cur = nextNode;
//        }
//        cur.end++;
//    }

    /**
     * Adds a word into the data structure.
     * word="",root.end++
     */
    public void addWord(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (cur.nexts[idx] == null) {
                cur.nexts[idx] = new TrieNode();
            }
            cur = cur.nexts[idx];
        }
        cur.end++;
    }


    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    /**
     * @param chars chars
     * @param k     待查看的点
     * @param node  代查看点的父节点
     */
    private boolean match(char[] chars, int k, TrieNode node) {
        if (k == chars.length) {
            //重点，node是父节点。如果k越界代表遍历结束。应该看k-1那个节点end是不是为0
            //就算chars等于空，同样适用，node=root
            return node.end != 0;
        }
        if (chars[k] != '.') {
            return node.nexts[chars[k] - 'a'] != null && match(chars, k + 1, node.nexts[chars[k] - 'a']);
        }
        for (int i = 0; i < 25; i++) {
            if (node.nexts[i] != null) {
                if (match(chars, k + 1, node.nexts[i])) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _211 s = new _211();
        s.addWord("at");
        s.addWord("and");
        s.addWord("an");
        s.addWord("add");
        System.out.println(s.search("a"));
        System.out.println(s.search("dad"));
        System.out.println(s.search(".ad"));
        System.out.println(s.search("...."));
        System.out.println(s.search(""));
    }
}
