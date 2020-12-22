package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2sum����������С��һ�������±�0�ĺ���������������Ҫ����������map���һ��0��1��
 * ����ת����O��N���������������ۼӺͣ�Ȼ�������е�pair����������֮�����k
 * ��������ۼӺ����õ���k,Ҳ������������
 *
 * @author Zhancong Huang
 * @date 10:24 2019/7/16
 */
public class _560 {

    /**
     * ����һ�����飬O��N��ʱ�����ҵ��ж��ٸ�������͵���target ,�����鳤�Ȳ�Ҫ��
     * ˼·��
     * ��i������ÿ��λ�ñ���0����ǰ���ֵĺͣ�����map��keyΪ����ͣ�valueΪ���ֵĴ���
     * ��i����������map��������key��key+target���õ��ڵ�ǰ���ֶ�Ӧ�ĺ͡�
     * �������Ҳ��2sum������������ģ�֮ǰ�������ֺ���ô���������������ֵ��±�0�ĺ�֮��Ĳ�ֵ��ô��
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(256);
        //��©.sum���õ���k,Ҫȥ��ǰ��sum=0�ĳ��ִ���
        map.put(0, 1);
        //����[0,i]�������
        int subSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //���ߴ���������i��i֮ǰ�ı�����
            subSum += nums[i];
            //ע���ʱmap��֤��Ķ�����i֮ǰ�����ܳ���[0,i]�Լ��ĺ͵���k������ǰ��Ҫput 0,1
            result += map.getOrDefault(subSum - k, 0);
            //���뵱ǰsubSum
            map.put(subSum, map.getOrDefault(subSum, 0) + 1);
        }
        return result;
    }
}
