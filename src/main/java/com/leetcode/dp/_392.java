package com.leetcode.dp;



import com.leetcode.BinarySearch.BinarySearchUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/is-subsequence/discuss/87344/Greedy-Alg-Dynamic-Programming-Binary-Search-plus-Follow-Up-Analysis
 *
 * @author Zhancong Huang
 * @date 22:51 2018/11/29
 */
public class _392 {

    //两个指针i,j，指向的值相等同时移动，否则移动母字符串的指针。最后看子字符串指针是否移到末尾
    //greedy. 就是最朴素的搜索O（M+N）

    /**
     * bS. https://leetcode.com/problems/is-subsequence/discuss/87302/Binary-search-solution-for-follow-up-with-detailed-comments
     * s长度m, t长度n. 时间复杂度： O（n） + O（m*logN）
     */
    public static boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256];
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null) {
                idx[t.charAt(i)] = new ArrayList<>();
            }
            idx[t.charAt(i)].add(i);
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) {
                return false;
            }
            int[] tmp = new int[idx[s.charAt(i)].size()];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = idx[s.charAt(i)].get(j);
            }
            prev = BinarySearchUtil.findFirstLarger(tmp, prev);
            if (prev == tmp.length) {
                return false;
            }else {
                prev = tmp[prev];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acb", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
