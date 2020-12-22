package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意EmlementSwap 数字大小是0 - N，这里是1 - N+1
 * while条件里要转换下
 *
 * @author Zhancong Huang
 * @date 18:49 2019/1/22
 * @see EmlementSwap
 * 跟448重复
 */
public class _442 {
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1 && nums[i] - 1 != nums[nums[i] - 1] - 1) {
                int temp1 = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp1 - 1] = temp1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
