package com.jianzhiOffer;


/**
 * 重点：combination特例used数组不释放
 * 就是岛问题的单次感染，与一般combination问题不一样的地方，used数组不用回置，且属于起点特殊类型
 * 为什么不能释放used?
 * 2*2的方格，按逆时针搜索，00 10 11 01 然后全部释放。
 * 最后00 往右走，又会遇到01
 *
 * @author Zhancong Huang
 * @date 19:38 2019/4/30
 */
public class p66 {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 1 || threshold < 1) return 0;

        int[] result = new int[1];
        boolean[][] used = new boolean[rows][cols];
        used[0][0] = true;
        helper(result, 0, 0, rows, cols, used, threshold);
        return result[0];
    }

    /**
     * 进入这个方法。代表x,y这个点可以走到
     */
    private void helper(int[] result, int x, int y, int rows, int cols, boolean[][] used, int threshold) {
        //走到这里已经代表xx,yy可以走到。一般在这里处理到这里的PATH，此题不需要
        result[0]++;

        for (int[] dir : dirs) {
            int xx = x + dir[0], yy = y + dir[1];
            //判断能不能走到
            if (xx >= rows || xx < 0 || yy >= cols || yy < 0 || used[xx][yy] || calculate(xx) + calculate(yy) > threshold)
                continue;
            used[xx][yy] = true;
            //进入下面这个栈帧的时候，xx,yy已经走到了，必须置Used[xx][yy].牢记模板for里面有6句
            helper(result, xx, yy, rows, cols, used, threshold);
            //岛问题的特殊之处，这里不能释放used。(属于岛问题的感染步骤，牢记这一类型)
            //used[xx][yy] = false;
        }

    }

    private int calculate(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }


}
