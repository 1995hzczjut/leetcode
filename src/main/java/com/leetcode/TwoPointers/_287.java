package com.leetcode.TwoPointers;

import com.leetcode.array.EmlementSwap;

import java.util.Arrays;

/**
 * 一种比较巧，构造出一个链表，很难想到。
 * 第二种是通法，比较慢，推荐第二种。
 *
 * @author Zhancong Huang
 * @date 8:45 2019/8/13
 */
public class _287 {

    /**
     * 0 1 2 3 4 5 6 7
     * [4,6,2,1,7,1,3,5]
     * 自己构建链表0 -> 4 -> 7 -> 5 -> 1 -> 6 -> 3 -> 1 -> 6 -> 3 -> 1 -> 6 -> 3 -> 1 ... 一直重复 1 6 3
     * 重复的数字1  就是环的起点.
     * 写法严格参考142
     * do{
     * fast == null || fast.next == null => 无环，return
     * fast = fast.next.next;
     * slow = slow.next;
     * }while (fast != slow);
     * 走到这里代表有环
     */
    public int findDuplicate(int[] nums) {
        /**
         * 变成有环链表找起点问题了。难在构建出上面的链表，以及指针怎么走
         */
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    /**
     * 数组长度N+1，每个数字大小在[0,N]或[1,N+1]之间，必然可以O（N）尽量让每个数字归位
     * 9/30:运气好，下面的其实是错的，但也能通过，说了数字是1到n之间，下面的写法是0到n-1，
     * 正确的看448
     *
     * @see EmlementSwap
     */
    public int findDuplicateUsingEmlementSwap(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            while (i != nums[i] && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
        }
        System.out.println("after swapping: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return nums[i];
        }
        return -1;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
