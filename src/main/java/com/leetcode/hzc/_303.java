package com.leetcode.hzc;

public class _303 {

    /**
     * ˵��Ҫ��ε�����ͷ�����Ӧ���ڹ��캯������������е�ֵ������һ��HAHMAP��
     * ������ѯ��ʱ����o��1��
     * ���������ǹ��캯����д���������Ļ��ռ临�Ӷ���o(n^2)
     * ��ȷ��������sumRange(i, j) = sum[j + 1] - sum[i]
     * orz û���п�
     * ��int[] sums = new int[0];
     * sums[0] = 1;���϶�����
     * ��ô����nums[-1] sum[-1]?
     */
    public static class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            if (nums == null) {
                sum = null;
            } else if (nums.length == 0) {
                sum = new int[0];
            } else {
                sum = new int[nums.length];
                sum[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (sum == null) {
                return 0;
            }
            if (i >= sum.length || j >= sum.length || j < i) {
                return 0;
            } else if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i - 1];
            }
        }
    }


    public static void main(String[] args) {

    }

}
