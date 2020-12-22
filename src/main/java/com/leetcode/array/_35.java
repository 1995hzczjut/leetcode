package com.leetcode.array;

/**
 *  用自己的两分模板轻松AC。注意返回值
 *  转化为两分问题： 第一个大于等于tagert的idx. 如果不存在，分类：
 *  target 比最大的还大。 返回nums.len - 1
 *  比最小的还小 返回0
 * @author Zhancong Huang
 * @date 16:23 2018/10/3
 */
public class _35 {
    /**
     * error：
     * right 是移到Mid左边 不是-- --复杂度就不是Log了
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            System.out.println(left+","+right);
            int mid = (left + right) >> 1;
            if(nums[mid] >= target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        System.out.println(left+","+right);
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6};
        int t = 5;

        System.out.println(searchInsert(a,t));
    }
}
