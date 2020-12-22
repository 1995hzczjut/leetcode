package com.leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/wzj4858/p/7723897.html
 * 贪心O（logN + N）==》  两分O（logN + k）
 *
 * @author Zhancong Huang
 * @date 9:47 2018/11/12
 */
public class _658 {
    /**
     * 贪心O（logN + N）
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //先全部加进去
        List<Integer> res = new ArrayList(arr.length);
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        //再挨个删掉
        while (res.size() > k) {
            //考虑x在或者不在arr的情况，都是从两边开始删
            if (Math.abs(x - res.get(0)) <= Math.abs(x - res.get(res.size() - 1))) {
                res.remove(res.size() - 1);
            } else {
                res.remove(0);
            }
        }
        return res;
    }


    /**
     * 两分O（logN + k）
     */
    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        //TODO
        //https://leetcode.com/problems/find-k-closest-elements/discuss/106419/O(log-n)-Java-1-line-O(log(n)-+-k)-Ruby?page=1

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 3, 5, 6, 7, 8, 8};
        int k = 2, x = 2;

        System.out.println(findClosestElements(nums, k, x));
    }
}
