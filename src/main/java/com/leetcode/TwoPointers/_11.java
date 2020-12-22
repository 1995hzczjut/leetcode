package com.leetcode.TwoPointers;

/**
 * ������2sum_sorted����
 *
 * @author Zhancong Huang
 * @date 10:36 2019/8/11
 */
public class _11 {

    /**
     * ���Ӷȱ���N^2  Ҫ��N
     * ���Ӷȿ��Խ�������Ŀ����������һ�����������Լ����������裺
     * ����ָ��ָ�����ִ����������ӣ������������̵������ƶ���������Ȼ���͡�
     * �������װ���������
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, (right - left) * (Math.min(height[left], height[right])));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}
