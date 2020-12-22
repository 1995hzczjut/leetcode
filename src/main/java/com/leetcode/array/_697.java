package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 题目说了这么多，要求的就是出现频率最高的数 第一次出现 最后一次出现的间距
 * 最暴力：Map1<数，出现的次数> Map2<数，（第一次出现的pos,最后一次Pos）>
 * 全部存进去后，遍历Map1，找到出现最多次数的数（不止一个？）。再遍历Map2
 * 上面要2次遍历。 上面两个map可以合并。
 * 单循环：以DP的思路即在线处理分析：
 * 便利到新位置i时，maxCount 看成在此之前的度对应的出现次数。现在遇到了i，只处理i，
 * 那么看nums[i]出现的次数，跟maxCount 比较，共分两种情况，要算出结果，还需要另外一个MAP存
 *
 * @author Zhancong Huang
 * @date 18:51 2019/1/13
 */
public class _697 {

    /**
     * 比较直观的思路
     */
    public int findShortestSubArray1(int[] nums) {
        if (nums.length < 2) return 1;
        //value:{出现的次数，第一次出现的位置，最后一次出现的位置}
        Map<Integer, int[]> map = new HashMap<>(256);
        for (int i = 0; i < nums.length; i++) {
            int[] value = null;
            if (map.containsKey(nums[i])) {
                value = map.get(nums[i]);
                value[0]++;
                value[2] = i;
            } else {
                value = new int[3];
                value[0] = 1;
                value[1] = value[2] = i;
            }
            map.put(nums[i], value);
        }
        //找度
        int degree = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            degree = Math.max(degree, entry.getValue()[0]);
        }

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] == degree) {
                result = Math.min(result, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return result;
    }


    /**
     * DP 优化空间
     */
    public int findShortestSubArray(int[] nums) {
        //<数字，出现次数>
        Map<Integer, Integer> countMap = new HashMap<>(256);
        //<数字，第一次出现的位置>
        Map<Integer, Integer> posMap = new HashMap<>(256);
        //当前度
        int result = 0;
        //度的次数
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = countMap.getOrDefault(nums[i], 0) + 1;
            int startPosition = posMap.getOrDefault(nums[i], i);
            countMap.put(nums[i], count);
            posMap.put(nums[i], startPosition);
            System.out.println(String.format("数字%d出现%d次，初始位置%d", nums[i], count, startPosition));
            if (count > maxCount) {
                //新的度出现了。
                maxCount = count;
                result = i - startPosition + 1;
            } else if (count == maxCount) {
                //取最小的
                result = Math.min(result, i - startPosition + 1);
            }
        }
        return result;
    }


}
