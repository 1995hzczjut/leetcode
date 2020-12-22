package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 11:00 2019/8/13
 */
public class _69 {


    /**
     * �������̣�
     * ���ֱ����ǣ���nums[mid]��ֵ�ų�����ߺ�ѡ�ߣ�����Ҳ��һ����
     * ����nums[mid]=mid=5,n��case��25 30 20��100
     * 5*5=25,���Է�����
     * 5*5<30,����һ���������[1,5]����Ҫ�ҵģ�������left=mid+1
     * ������������⣬Ҫ����ӽ��ģ�sqrt30����λ��5��6֮ǰ����ĿҪ�󷵻�sqrt30���������֣�
     * �����������ҲҪֱ�ӷ���
     * 5*5>20�������������sqrt20λ��4,5֮�䣬Ӧ�÷���4������5��5�ұߵĿ��Ըɵ���
     * 5*5��100,����100����56֮�䣬5��5��߸ɵ���
     *
     */
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) >> 1;
            //�ó˷������
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

}
