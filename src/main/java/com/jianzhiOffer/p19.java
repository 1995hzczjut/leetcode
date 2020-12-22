package com.jianzhiOffer;


import java.util.ArrayList;

/**
 * @author Zhancong Huang
 * @date 14:41 2019/4/20
 */
public class p19 {
    /**
     * 指针指向一定是合法的地方
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (left > --right) break;

            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (top > --bottom) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;

    }
}
