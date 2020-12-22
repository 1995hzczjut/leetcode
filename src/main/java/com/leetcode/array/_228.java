package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 22:44 2019/1/17
 */
public class _228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        //start end 表示连续区间
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>(256);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                //这一步不加，如果0234序列，就缺各0
                map.put(start, end);
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                map.put(start, ++end);
            } else if (nums[i] != (nums[i - 1] + 1)) {
                map.put(start, end);
                end = start = i;
                //不加，单个数字情况永远漏掉
                map.put(start, end);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int s = entry.getKey();
            int e = entry.getValue();
            if (s != e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(nums[s]);
                stringBuilder.append("->");
                stringBuilder.append(nums[e]);
                result.add(stringBuilder.toString());
            } else {
                result.add(String.valueOf(nums[s]));

            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(new _228().summaryRanges(nums));
    }
}
