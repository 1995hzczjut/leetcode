package com.leetcode.tmp;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 22:07 2019/2/13
 */
public class ArrayEasy1 {


    /**
     * 1
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(256);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    /**
     * 26
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        //其向左的闭区间代表结果存放的地方
        int j = 0;
        //遍历用指针
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    //27
    public int removeElement(int[] nums, int val) {
        int resultIdx = -1;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++resultIdx] = nums[i];
            }
        }
        return resultIdx + 1;
    }

    //35.找第一个大于等于target的数。没有要求返回Nums.length
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int k = m + n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] >= nums2[q]) {
                nums1[k--] = nums1[p--];
            } else {
                nums1[k--] = nums2[q--];
            }
        }
        while (q >= 0) {
            nums1[k--] = nums2[q--];
        }
    }

    public int maxProfit(int[] prices) {
        //在线处理
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                cur = nums[i];
                count = 1;
            } else {
                count = cur == nums[i] ? count + 1 : count - 1;
            }
        }
        return cur;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int row = 0, col = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                //赋值前保证坐标合法
                result[row][col] = nums[i][j];
                if (++col >= c) {
                    row++;
                    col = 0;
                }
            }
        }
        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(256);
        Map<Integer, Integer> startPosMap = new HashMap<>(256);
        int result = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = countMap.getOrDefault(nums[i], 0) + 1;
            countMap.put(nums[i], count);
            int startPos = startPosMap.getOrDefault(nums[i], i);
            startPosMap.put(nums[i], i);
            if (count > maxCount) {
                maxCount = count;
                result = i - startPos + 1;
            } else if (count == maxCount) {
                result = Math.min(result, i - startPos + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
