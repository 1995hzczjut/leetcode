package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * 这个算法的最大用处看442 448 485
 * 这种数组很特殊，有自己的特性，经常遇到
 * 小心448这种N+1个数，范围是1，N+1.而不是0，N
 * 如果用0，N的做法做出来全是错的。
 * todo: 整理下
 *
 * @author Zhancong Huang
 * @date 23:29 2018/9/29
 */
public class EmlementSwap {
    /**
     * 给定一个数组，乱序，0到数组长度-1， O（n） 内可以排序。
     * 如果数组有几个数变成了其他数的复制，很快可以找到
     * https://blog.csdn.net/yutianzuijin/article/details/11384507
     * 数组统计的一种通用方法，跟KMP很像
     * nums 从0开始
     *
     * @param nums
     */
    public void modifyArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //下面条件看仔细，while里面单次必定让一个i 使得 i = nums[i]
            //一旦 i = nums[i] 必定不会再换。所以整个for 最差就是O（N），单个while O（1）
            //均摊分析
            //循环退出的时候, i 或者 n[i]至少有一个对上位了（nums不一定正好都是0到n,例如01224这种）
            while (i != nums[i] && nums[i] != nums[nums[i]]) {
                //swap 类似并发修改异常的错误
                int temp1 = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp1] = temp1;
            }
            //System.out.println("i:" + i + " n[i]:" + nums[i] + " n[n[i]]:" + nums[nums[i]]);
        }
    }

    public static void main(String[] args) {
//        int[] a = {3,0,2,1,4,9,8,7,5,6};
//        int[] a = {3,0,2,8,8,1,8,7,5,6};
        int[] a = {0,1,2,2,4};
//        int[] a = {4,3,2,7,8,2,3,1};
//        int[] a = {1, 3, 4, 2, 2};

        new EmlementSwap().modifyArray(a);
        System.out.println(Arrays.toString(a));
    }

}
