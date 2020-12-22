package com.leetcode.array;


import java.util.LinkedList;
import java.util.List;

/**
 * 代码非常简洁，背也要背出来
 *
 * @author Zhancong Huang
 * @date 21:29 2019/1/16
 */
public class _54 {

    /**
     * 非常好的思路。四个点代表当前要打印的矩阵，打印完一行后，立马更新对应的顶点
     * 不合法立马break
     * 总之保证每次打印时，四个点代表的矩阵是合法的，没有被打印过的
     * 因此写出的代码比较整洁。整个过程一直
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            //不是++top > nums.length - 1
            //++top > bottom 有具体意义的，代表这个动态维护的矩阵已经扁到没有了
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
