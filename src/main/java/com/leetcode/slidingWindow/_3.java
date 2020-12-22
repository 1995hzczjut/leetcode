package com.leetcode.slidingWindow;


/**
 * ������������ı��棺
 * ˼·�����Ƕ���һ��ͷָ�룬����һ��βָ�룬ÿһ������ͷβָ��ȷ��һ�����ظ������� ���Ӵ�
 * һ����������һ����ͬ�����Ǿ���ͷָ����Ƶ����ظ���λ��Ȼ��ά�����ǵ����ֻ��ŵı�����֪�����ǵ�Ϊָ��ɨ�����������ַ���
 * ֱ��������ĳ��ȾͿ�����
 *
 * �������ڷ���
 * ��ʵ����ת��ΪDP��������ֵ�������DP�ܽ����������dp[i]��ʾi֮ǰ�����������������Ӵ�
 * dp[i+1]�Ϳ�i+1λ�õ��ַ�d�Ƿ������Dp[i]������������棬DP������⡣
 * �������ڵĻ����Ĺ��̣�
 * �д��ڻ����������ޣ���ʱ�󴰿����һ���������DP����⡣
 * �ѵ���Ȼ������ô֪��i+1�Ƿ������DP[i]
 *
 *  209ͬ��������
 * @author Zhancong Huang
 * @date 20:07 2019/7/31
 */
public class _3 {

    /**
     * ֮ǰ�İ汾�����⣺MAPһֱά��ȫ�ֵ�ֵ����ʵû�б�Ҫ�ģ�ֻά�������ڵ�CharMap����
     * ���ڻ���ʱ�򣬸���Charmap���ɣ�������������Ը��á�
     * ע�ⲻ���ִ�Сд
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        //���ڳ�ʼ1���е�ʱ��0����rightָ��-1�������
        int left = 0, right = 0;
        //��̬ά��[left,right]�ģ�������Ķ���0
        int[] charMap = new int[256];
        //�������ڻ����Ҵ�����Ϊȫ�ֱ���
        for (; right < s.length(); right++) {
            //û�����ظ���
            if (charMap[s.charAt(right)] == 0) {
                charMap[s.charAt(right)] = 1;
                result = Math.max(result, right - left + 1);
            } else {
                //��������ַ���[left,right]��ĳ��λ�ó��ֹ���
                //��ʱ�ƶ�left���ظ�λ�õ��ұߣ�charMapҪ����
                while (s.charAt(left) != s.charAt(right)) {
                    charMap[s.charAt(left++)] = 0;
                }
                //�˳�ʱleftָ���м��Ǹ�λ�õ��ظ�ֵ
                left++;
                //��������Ժϲ������ĸ���
                charMap[s.charAt(right)] = 1;
            }
        }
        return result;
    }


}
