package com.leetcode.BinarySearch;

/**
 * 至今没想明白,target选在nums[0]是错的，Case就是无旋转的情况
 * 记住，比较的target是末尾，最终返回按照无旋转的思考，等号也是。
 *
 * @author Zhancong Huang
 * @date 15:18 2019/8/12
 */
public class  _153 {
    public  int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    /**
     * 比较点选在最左边是错的。！！！
     */
    public  int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

    }
}
