package com.leetcode.Backtracking;

/**
 * combination问题的特殊情况：起点先加入tmp。之前由于不需要切换起点，所以简单一点。
 * 这里一定注意，要切换起点，不处理就错了。类似79的有向图检测环，起点也是任意的，那题还没没改。
 *
 * 其实改成岛问题的那个写法，比较简洁。
 *
 * @author Zhancong Huang
 * @date 19:46 2018/10/30
 */
public class _79 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    //错误：漏掉了，图论DFS的模板牢记，遍历到一个点，先把自己在visited标记下
                    //因为遍历到一个点，这个点自己已经被考察过了，所以必须修改visited。之后一定要改回来
                    visited[i][j] = true;
                    if (helper(board, visited, word, i, j, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, boolean[][] visited, String word, int x, int y, int matchedLen) {
        //这里考虑走到了后的PATH的特性①
        if (matchedLen == word.length()) {
            return true;
        }
        for (int[] dir : dirs) {
            int xx = x + dir[0], yy = y + dir[1];
            //这里考虑能不能走到②
            //1 2 都要处理回溯
            if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length || visited[xx][yy] || board[xx][yy] != word.charAt(matchedLen)) {
                continue;
            }
            //这里没有tmp增删
            visited[xx][yy] = true;
            if (helper(board, visited, word, xx, yy, matchedLen + 1)) {
                return true;
            }
            visited[xx][yy] = false;
        }
        return false;
    }
}
