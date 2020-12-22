package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *  题目没说复杂度要求的，优先时间降到最低。
 *  像这题O（N^2）可暴力解决。显然不行，套路还是Map存
 * @author Zhancong Huang
 * @date 11:26 2019/1/13
 */
public class _532 {

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(k == 0){
                if(entry.getValue() >= 2){
                    result++;
                }
            }else {
                if(map.containsKey(entry.getKey() + k)){
                    //containsKey 也是算hash值的，是O（1）的操作
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new _532().findPairs(new int[]{3,1,4,1,4}, 2);
    }

}
