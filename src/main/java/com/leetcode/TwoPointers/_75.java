package com.leetcode.TwoPointers;

public class _75 {

    /**
     * �����������⡣�����д��
     * int less = start - 1;  int more = end + 1; ������ָ���ĺ����
     * swap(nums, idx++, ++less);  swap(nums, idx, --more);  ��������ָ����ô�ƶ���
     */

    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1, 1);
    }


    public void partition(int[] nums, int start, int end, int target) {
        //(-inf, less] ����С��target
        int less = start - 1;
        //[more, +inf) �������target����less, more���������
        //less,more ָ���������Ѿ��������������ģ�����Ҫ�������Բ��ύ����������
        int more = end + 1;
        int idx = start;
        //��ֹ����С�ģ�����<end
        while (idx < more) {
            if (nums[idx] < target) {
                swap(nums, idx++, ++less);
            } else if (nums[idx] > target) {
                swap(nums, idx, --more);
            } else {
                idx++;
            }
        }

    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }



    public static void main(String[] args) {

    }

}
