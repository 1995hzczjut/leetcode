package com.leetcode.math;

import java.util.Arrays;

/**
 * �������⣬��һ�۸��Ӵ��ڵ���N2��һ���ȿ���������˼��O��N��
 *
 * @author Zhancong Huang
 * @date 15:36 2019/8/10
 */
public class _628 {

    /**
     * ע�����������и�,��Ҫ�Ƿ����� ���̡�
     */
    public int maximumProduct1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        if (nums[j] <= 0) {    //���鶼�Ƿ������������ֵ��������������
            return nums[j] * nums[j - 1] * nums[j - 2];
        } else {   //�����и���[-3,-2,1,2,3] [1,2,3,4,5] �����Ǹ�����Ȼ�ǣ��������������
            return Math.max(nums[j] * nums[j - 1] * nums[j - 2], nums[i] * nums[i + 1] * nums[j]);
        }
    }

    //������������Ĵ��п��Կ�����ֻ��Ҫ�ҵ�5�����Ϳ����ˣ�2����С�ģ�3������
    //��414 �ȣ����ö����ظ���
    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE; //��С��
        int min2 = Integer.MAX_VALUE; //�ڶ�С
        int max1 = Integer.MIN_VALUE; //����
        int max2 = Integer.MIN_VALUE; //�ڶ���
        int max3 = Integer.MIN_VALUE; //������

        //���ﲻ����if(continue:)ʵ���ˣ�ֻ��������if-else
        for (int i : nums) {
            if (i < min1) {    //min2��ʾ�ڶ�С������С�ĸ����ˣ�Ҫ����µĸ�С���ˣ�min2Ӧ�ø��£�
                min2 = min1; //��©д��
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }

            if (i > max1) {     //���ĸ����ˣ��ڶ���������Ҫ����
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) { //�ڶ�����£�������Ҫ��=������
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {

    }

}
