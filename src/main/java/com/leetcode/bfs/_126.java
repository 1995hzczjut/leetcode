package com.leetcode.bfs;

import java.util.*;

/**
 * 首先对127优化，优化点在于 当前层 出现了 之前层 出现过得应该直接删掉 todo
 * 然后先找到层数有几层，充分利用BFS的特点，再利用DFS
 * 答案有直接BFS 这样图的每一个结点是List,很麻烦
 *
 * @author Zhancong Huang
 * @date 17:01 2020/6/22
 */
public class _126 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;

        Map<String, List<String>> map = getMap(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String polled = queue.poll();
                List<String> nextLevel = getNextLevel(polled, map);
                for (String str : nextLevel) {
                    if (str.equals(endWord)) return level;
                    if (set.contains(str)) continue;
                    set.add(str);
                    queue.offer(str);
                }
            }
        }
        return 0;
    }


    private static Map<String, List<String>> getMap(List<String> wordList) {
        HashMap<String, List<String>> ret = new HashMap<>(256);
        for (String str : wordList) {
            for (int i = 0; i < str.length(); i++) {
                String newStr = str.substring(0, i) + "*" + str.substring(i + 1, str.length());
                if (!ret.containsKey(newStr)) {
                    ret.put(newStr, new ArrayList<>());
                }
                ret.get(newStr).add(str);
            }
        }
        return ret;
    }

    private static List<String> getNextLevel(String polled, Map<String, List<String>> map) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < polled.length(); i++) {
            String newStr = polled.substring(0, i) + "*" + polled.substring(i + 1, polled.length());
            if (!map.containsKey(newStr)) continue;
            //addall要保证不空
            ret.addAll(map.get(newStr));
        }
        //这个集合一定大量重复
        return ret;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));
        //System.out.println(getMap(Arrays.asList(wordList)));
        //System.out.println(getNextLevel("dot", getMap(Arrays.asList(wordList))));
    }

}
