package com.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**todo
 * @author Zhancong Huang
 * @date 9:09 2020/5/10
 */
public class _992 {
    public static int subarraysWithKDistinct(int[] A, int K) {
        if (A.length == 0 || K == 0) return 0;
        int ans = 0, left = 0, right = 0;
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>(256);

        for (; right < len; right++) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            while (map.size() > K) {
                if (map.get(A[left]) > 1) {
                    map.put(A[left], map.get(A[left]) - 1);
                } else {
                    map.remove(A[left]);
                }
                left++;
            }
            int temp = left;
            while (map.size() == K) {
                System.out.println(left + " " + right);
                ans++;
                if (map.get(A[temp]) > 1) {
                    map.put(A[temp], map.get(A[temp]) - 1);
                } else {
                    map.remove(A[temp]);
                }
                temp++;
            }

            while (temp > left) {
                map.put(A[temp - 1], map.get(A[temp - 1]) + 1);
                temp--;
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(a, 2));
    }
}
