package com.leetcode.array;

/**
 *  理解题意就行。
 * @author Zhancong Huang
 * @date 22:41 2018/9/28
 */
public class _566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c != nums.length * nums[0].length){
            return nums;
        }
        int row = 0,col = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                result[row][col] = nums[i][j];
                if(++col >= c){
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4);
    }
}
