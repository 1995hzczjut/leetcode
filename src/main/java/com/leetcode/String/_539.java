package com.leetcode.String;

import java.util.List;

public class _539 {

    /**
     * ��Ŀ�������ɸ�ʱ�䣬����ѡ����ʱ����Եõ�һ����ֵ�������в�ֵ�о���ֵ��С���Ǹ�
     * ����϶����У���ĿҪ��O��N������Ȼ�뵽O��N���ķǱȽϵ����򷽷�����Ͱ����
     * ����Ͱ����Ҳ����֪�ģ��Ȱ�����ת���ɷ������Ž�Ͱ�ˡ�һ��Ͱ��int[]���飬�������ֱ�ʾ�м�����������Ͱ��
     * Ȼ��������ɡ�������Ŀ����case��ʾʱ����ѭ���ģ�������Ҫ�ҵ���С��ʱ�������ʱ�䣬�����һ��
     */
    public int findMinDifference(List<String> timePoints) {
        boolean[] buckets = new boolean[24 * 60];
        for (String s : timePoints) {
            String[] arr = s.split(":");
            int num = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
            //�ӣ�Ͱ��������Ͱ��ֻ�ܷ�һ�����ݣ���ô��ʾ��������
            if (buckets[num]) return 0;
            buckets[num] = true;

        }

        int first = 24 * 60;
        int last = -1;
        int pre = 0;
        int min = Integer.MAX_VALUE;

        //�߼��ܸ㣡����
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]) {
                // firstû�ҵ�����min����֤��һ��Ͱ����ֵ����min.����min�ŵ�ǰ��
                if (first != 24 * 60) {
                    min = Math.min(min, i - pre);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                pre = i;

            }
        }
        //���case��Ŀ����
        return Math.min(min, (24 * 60 - last + first));
    }

    public static void main(String[] args) {

    }

}
