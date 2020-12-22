package com.leetcode.dfs;

public class _720 {

    /**
     * 好题,题目讲的不清楚
     * 按照视频构建的前缀树。题意是说，如果要构建apple，必须a,ap,app,appl都要在树中。
     * 提交时候 静态内部类的问题。内部类有构造方法的话加静态？
     */
    public static class TrieNode {
        //public int path;  表示经过的次数，此题用不到
        //public int end;  表示以这个点结尾的次数，此题用不到
        public TrieNode[] nexts;
        public String word = ""; //表示以这个点结尾的字符串，用在记录插入时的变量.后面搜索要用到

        public TrieNode() {
            nexts = new TrieNode[26];
        }

    }

    //前缀树
    public static class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.word = "-"; //还是要放，不然DFS第一步就结束了
        }

        public void insert(String s) {
            if (s == null) {
                return;
            }
            char[] chs = s.toCharArray();
            TrieNode curNode = root; //从根节点开始插的
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (curNode.nexts[index] == null) {
                    curNode.nexts[index] = new TrieNode();
                }
                curNode = curNode.nexts[index]; //指向刚建的
                //curNode.path++; 表示经过这个结点（往上看）路径+1
            }
            //curNode.end++; 表示以这个结点结尾（往上看）+1
            curNode.word = s;
        }

    }

    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return helper(trie.root, "");
    }

    //功能是返回一个结点下面的最长字符串。
    public static String dfs(TrieNode node, String lastWord) {
        //终止条件。
        String res = "";
        if (node == null || node.word.length() == 0) {
            res = lastWord.equals("-") ? "" : lastWord;
            return res;
        }

        for (TrieNode child : node.nexts) {
            String tempRes = dfs(child, node.word);
            if (tempRes.length() > res.length() || (tempRes.length() == res.length() && tempRes.compareTo(res) < 0)) {
                res = tempRes;
            }
        }
        return res;

    }

    public static String helper(TrieNode treeNode, String res) {
        if (treeNode == null) {
            return res;
        }
        if (!treeNode.word.equals("_")){
            res = check(res, treeNode.word);
        }
        for (TrieNode node : treeNode.nexts) {
            res = check(res, helper(node, res));
        }
        return res;
    }

    private static String check(String s1, String s2) {
        if (s1.length() > s2.length() || s1.length() == s2.length() && s2.compareTo(s1) < 0) {
            return s1;
        }
        return s2;
    }


    public static void main(String[] args) {
        String[] a = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] a1 = {"w"};
        System.out.println(longestWord(a));
        //System.out.println('o' - 'a');

    }

}
