package com.leetcode.array;

/**
 * （1）经典的问题，TOP k,问题有两种问题，一种是输出前K个，还有一种是第K个。
 * K小的话，都可以用这里的写法；K大的话要预设很多变量，第一个问题只能用堆
 * 第二个问题还可以借助快排的思路。
 * （2）另外top K,K个数字有没有重复也要考虑，例如2231，不允许重复的话，第3大的数字是1
 * 允许重复的话则是2，所以遍历到一个数字时，要与之前的比较，判断时候重复，
 * 这一点在super ugly num也有体现，如果用优先级队列写的话,poll要poll出所有相等的数字
 * 而不是只有一个
 * （3）善用数值包装类，null对应这个数字还没有赋值的语义
 * （4）Integer为null时，不能拆箱，会报NPE，如下：
 * Integer max1 = null;
 * System.out.println(max1==1);  NPE
 * System.out.println(Integer.valueOf(1).equals(max1));  正确的做法
 *
 * @author Zhancong Huang
 * @date 19:11 2019/1/11
 */
public class _414 {

    public int thirdMax1(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        //只能用Integer去遍历
        for (Integer n : nums) {
            //不加这个 2 2 3 1.第一次是2 null null. 第二次2 2 null 第三次3 2 2 .1 永远进不去了。
            //而且不能用==比较。
            //这里不允许重复，所以要先判断
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;

    }


}
