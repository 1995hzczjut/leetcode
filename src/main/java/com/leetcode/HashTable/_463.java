package com.leetcode.HashTable;

public class _463 {

    /**
     * ˼·��
     * һ������4���ߣ�����������߶���1���������������ظ����ظ�������result�����������������ظ�
     * ������һ���߿����С�
     * ���ұ����������ڱ߽粻��Ū��Ҫ��������
     * �������������ң����±����ģ�����ֻ���ң����¿�
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int repeat = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
                        //���ұ��Ǹ������ҵı߱ض����ᱻ�ظ�
                        repeat++;
                    }
                    if (i != (grid.length - 1) && grid[i + 1][j] == 1) {
                        //���ұ��Ǹ������ҵı߱ض����ᱻ�ظ�
                        repeat++;
                    }
                }

            }
        }
        //һ���߱��ظ�����û���ظ���������ֵ
        return 4 * count - repeat * 2;

    }

    public static void main(String[] args) {

    }

}
