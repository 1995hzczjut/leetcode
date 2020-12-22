package com.leetcode.bfs;


import java.util.*;

/**
 * 难点在于构造图，图寻找某个距离起点最近的肯定用BFS
 *
 * @author Zhancong Huang
 * @date 19:50 2020/5/14
 */
public class _127 {

    /**
     * 链接：https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
     *
     * 最重要的步骤是找出只差一个字母的多个单词，即从当前单词一步能得到哪些单词。
     * 为了快速的找到这些相邻节点，我们对给定的 wordList 做一个预处理，将单词中的某个字母用 * 代替
     * 这个预处理帮我们构造了一个单词变换的通用状态。
     *
     * 我们使用一个Map来存储，键：通用状态；值：能得到这个通用状态的所有单词
     * 例如：Dog ----> D*g <---- Dig，Dog 和 Dig 都指向了一个通用状态 D*g。即键D*g对应的值为[Dog,Dig]
     *
     * 这步预处理找出了单词表中所有单词改变某个字母后的通用状态，并帮助我们更方便也更快的找到相邻节点。
     * 否则，对于每个单词我们需要遍历整个字母表查看是否存在一个单词与它相差一个字母，这将花费很多时间。
     * 预处理操作在广度优先搜索之前高效的建立了邻接表。
     *
     * 例如，在广搜时我们需要访问 Dug 的所有邻接点，也就是想知道由Dug能变换到字典中哪些单词
     * 我们可以先生成 Dug 的所有通用状态：以通用状态为键去获取值就可得到结果
     * Dug => *ug
     * Dug => D*g
     * Dug => Du*
     * 第二个变换 D*g 可以同时映射到 Dog 或者 Dig，因为他们都有相同的通用状态。拥有相同的通用状态意味着两个单词只相差一个字母，他们的节点是相连的。
     *
     */

    /**
     * 广度优先遍历(可认为是寻找全局最优解)
     * 1. 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
     * 2. 将键值对 <beginWord，1> 放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
     * 3. 为了防止出现环，使用访问数组记录当前单词已访问过。
     * 4. 当队列中有元素的时候，取出第一个元素，记为 current_word。
     * 5. 找到 current_word 的所有通用状态，并根据这些通用状态得到其对应的单词列表w1，w2，即从currWord能达到给定字典中的list中的w1和w2
     * 6. w1和w2都和 current_word 相连，因此将他们加入到队列中。
     * 7. 对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
     * 8. 最终当你到达期望的单词，对应的层次就是最短变换序列的长度
     * 相当于要从1得到9，发现1直接到达2和3，再操作2得到4和5，再操作3得到6和7，再操作4得到8和9，达到目标
     * 也就是一个广度优先遍历，因此需要借助 [队列] ，且要避免重复遍历
     */
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
