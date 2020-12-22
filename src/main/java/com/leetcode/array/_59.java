package com.leetcode.array;

/**
 * 跟54重复，完全一样的做法
 * @author Zhancong Huang
 * @date 23:17 2018/10/7
 */
public class _59 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        //表示4个坐标
        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = n - 1;
        int count = 1;

        while (left <= right){
            for(int i = left; i <= right; i++){
                result[top][i] = count++;
            }
            top++;

            for(int i = top; i <= down; ++i){
                result[i][right] = count++;
            }
            right--;

            for(int i = right; i >= left; --i){
                result[down][i] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                result[i][left] = count ++;
            }
            left ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));

    }
}
