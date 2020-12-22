package com.leetcode.greedy;


public class _556 {


    /**
     * 坑s.charAt(i)是一个char，要用其字面值时一定要小心减-‘0’
     */
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        //注意这个输出跟题目本身要求有差别
        nextPermutation(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = 10 * res + nums[i];
        }

        return res > Integer.MAX_VALUE || res <= n ? -1 : (int) res;
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Integer idx = findIdx(nums);
        swap(nums, idx);
        reverse(nums, idx);
    }

    private void reverse(int[] nums, Integer idx) {
        int start = idx == null ? 0 : idx + 1;
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 从右边开始找到第一个大于idx指的数字的数，并交换
     */
    private void swap(int[] nums, Integer idx) {
        if (idx == null) {
            return;
        }
        for (int i = nums.length - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                //记得直接break,不能换两次
                break;
            }
        }
    }

    /**
     * 从右边开始找到数组中第一次升序的左边数字
     * 输入已经保证了有两个，找不到返回NULL
     */
    private Integer findIdx(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return null;
    }


}
