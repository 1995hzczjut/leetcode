package com.leetcode.array;


/**
 * 数组Inplace问题，一定要先想到荷兰国旗问题是怎么交换数组的。
 * 如果确认可以做，格式直接参考
 *
 * @author Zhancong Huang
 * @date 13:31 2019/8/11
 */
public class _26 {


    /**
     * 参考荷兰国旗问题答案的格式
     * 格式：idx指针遍历全局，Less代表闭区间，while终止条件是遇到右区间
     */
    public int removeDuplicates1(int[] nums) {
        int less = -1, idx = 0;
        while (idx <= nums.length - 1) {
            if (less == -1 || nums[idx] != nums[less]) {
                swap(nums, ++less, idx);
            }
            idx++;
        }
        return less + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
