package com.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 与442重复
 * 参考类EmlementSwap. 这里从1开始，自己控制越界
 * @author Zhancong Huang
 * @date 23:38 2018/9/28
 */
public class _448  {


    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //初始值为1有点绕。idx=i 对应的数字的 正确索引 是这个数字值（nums[i]）减1. eg: 1 2 3 对应的索引是0 1 2
            //参考类EmlementSwap
            //while(i != nums[i] -1 && nums[i] != nums[nums[i] - 1]){
            while (i != nums[i] -1 && nums[i] -1 != nums[nums[i] -1] - 1){
                int temp1 = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp1 - 1] = temp1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //int[] a = new int[]{4,3,2,7,8,2,3,1};
        int[] a = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers1(a);
        System.out.println(Arrays.toString(a));

    }


}
