package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 *  要求O(K)extra space。 那就要只有一个list 不断演化。
 *  1331 -> 11331 -> 14641
 *  主要是演化的策略要记住
 * @author Zhancong Huang
 * @date 18:44 2018/10/3
 */
public class _119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i){
            list.add(0,1);
            for(int j = 1; j < i; j++){
                list.set(j, list.get(j) + list.get(j+1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
