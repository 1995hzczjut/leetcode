package com.leetcode.Heap;


/**
 * 要求O（N）
 * treemap只能对keySet排序。要对valueSet排序，只能转为list再用Collections，sort排序。那就nlogn了
 * 所以o(n)的要求只能抛弃map.
 * 可以推导：总长n ,  假设A字母最多有m个。若n-m >= m-1的话一定可以成功。这也是【关键】。
 * 如果可以就贪心的按照重复次数分配:
 * 例如A重复次数最多。是4次。建4个Stringbuilder.后面的字母就逐个扔进4个SB。
 * 这个分配的过程非常重要，其他题目里也出现过
 * 注意char跟整数在一起运算 new StringBuilder(String.valueOf((char) (maxIdx + 'a')));
 *
 * @author Zhancong Huang
 * @date 19:17 2018/9/15
 */
public class _767 {


    public static String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        //charMap
        int[] charMap = new int[26];
        for (int i = 0; i < S.length(); i++) {
            charMap[S.charAt(i) - 'a']++;
        }
        //找到最大值，不需要排序
        int maxIdx = 0, maxNum = 0;
        for (int i = 0; i < 26; i++) {
            if (charMap[i] > maxNum) {
                maxIdx = i;
                maxNum = charMap[i];
            }
        }
        //判断是否能重组。babab 出现最多的次数为n, 总长为m.n出现比例最高就是左边的情况。
        //非b的字母个数最小应该是2个，即夹在b之间，不能再小了
        //m/S.length() < m/2m-1
        if (2 * maxNum - 1 > S.length()) {
            return "";
        }
        //准备重组.按最大的出现次数划分桶，其他字母逐个加入桶中
        StringBuilder[] buckets = new StringBuilder[maxNum];
        for (int i = 0; i < buckets.length; i++) {
            //桶初始化
            buckets[i] = new StringBuilder(String.valueOf((char) (maxIdx + 'a')));
        }
        //其他字母一次加入桶中.是按charMap分配，而不是原先的S。这样才能保证不会右重复的间隔
        int bucketIdx = 0;
        for (int i = 0; i < charMap.length; i++) {
            if (i != maxIdx) {
                //charMap[i]表示还剩几个字母
                while (charMap[i]-- > 0) {
                    if (bucketIdx >= buckets.length) {
                        bucketIdx = 0;
                    }
                    buckets[bucketIdx++].append(String.valueOf((char) (i + 'a')));
                }
            }
        }
        //把所有的桶合在一起
        StringBuilder result = new StringBuilder();
        for (StringBuilder bucket : buckets) {
            result.append(bucket);
        }
        return result.toString();
    }

}
