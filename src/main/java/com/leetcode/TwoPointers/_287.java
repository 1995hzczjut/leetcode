package com.leetcode.TwoPointers;

import com.leetcode.array.EmlementSwap;

import java.util.Arrays;

/**
 * һ�ֱȽ��ɣ������һ�����������뵽��
 * �ڶ�����ͨ�����Ƚ������Ƽ��ڶ��֡�
 *
 * @author Zhancong Huang
 * @date 8:45 2019/8/13
 */
public class _287 {

    /**
     * 0 1 2 3 4 5 6 7
     * [4,6,2,1,7,1,3,5]
     * �Լ���������0 -> 4 -> 7 -> 5 -> 1 -> 6 -> 3 -> 1 -> 6 -> 3 -> 1 -> 6 -> 3 -> 1 ... һֱ�ظ� 1 6 3
     * �ظ�������1  ���ǻ������.
     * д���ϸ�ο�142
     * do{
     * fast == null || fast.next == null => �޻���return
     * fast = fast.next.next;
     * slow = slow.next;
     * }while (fast != slow);
     * �ߵ���������л�
     */
    public int findDuplicate(int[] nums) {
        /**
         * ����л���������������ˡ����ڹ���������������Լ�ָ����ô��
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
     * ���鳤��N+1��ÿ�����ִ�С��[0,N]��[1,N+1]֮�䣬��Ȼ����O��N��������ÿ�����ֹ�λ
     * 9/30:�����ã��������ʵ�Ǵ�ģ���Ҳ��ͨ����˵��������1��n֮�䣬�����д����0��n-1��
     * ��ȷ�Ŀ�448
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
