package com.exem.past;

import java.util.Scanner;

/**
 * @author Zhancong Huang
 * @date 19:25 2019/10/16
 */
public class HuaWei1 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalLen = sc.nextInt();
        if (totalLen < 1) {
            System.out.println(-1);
            return;
        }
        int[][] city = new int[totalLen][totalLen];

        for (int i = 0; i < totalLen; i++) {
            for (int j = 0; j < totalLen; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        boolean[][] used = new boolean[totalLen][totalLen];

        if (city[0][0] == 0) {
            System.out.println(-1);
        } else {
            used[0][0] = true;
            helper(result, 0, city, 0, 0, used);
            if (result[0] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(result[0]);
            }
        }

    }


    public static void helper(int[] result, int tmpLen, int[][] city, int x, int y, boolean[][] used) {
        if ((x == city.length - 1) && (y == city[0].length - 1)) {
            result[0] = Math.min(result[0], tmpLen);
            return;
        }

        for (int[] dir : dirs) {
            int xx = x + dir[0], yy = y + dir[1];
            if (xx < 0 || xx >= city.length || yy < 0 || yy >= city[0].length || used[xx][yy] || city[xx][yy] == 0)
                continue;
            used[xx][yy] = true;
            helper(result, tmpLen + 1, city, xx, yy, used);
            used[xx][yy] = false;
        }
    }
}
