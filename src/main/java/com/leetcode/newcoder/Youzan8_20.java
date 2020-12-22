package com.leetcode.newcoder;

import java.util.Scanner;

/**
 * @author Zhancong Huang
 * @date 17:00 2019/8/29
 */
public class Youzan8_20 {


    /**
     * 数轴上有N个点，第一个点的坐标是你现在的位置，第N-1个坐标是你的家。现在你需要依次从0号坐标走到N-1号坐标，但是除了0号和N-1号坐标，你可以在其余的N-2个坐标中选出一个点，并直接将这个店忽略掉，请问你回家至少要走多少距离？
     * 输入：整数N<=50,换行输入N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
     * 输出：一个整数表示最少需要走的距离
     *
     * 要求一定要顺序走
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        int cnt = Integer.parseInt(scanner.nextLine());
//        String s = scanner.nextLine();
        String s = "1,-1,7,3";
        String[] ss = s.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        func(array);
    }

    public static void func(int[] array) {
        int maxDis = Integer.MIN_VALUE;
        int totalDis = 0;
        // 计算如果不去掉点的实际路程
        for (int i = 1; i < array.length; i++) {
            totalDis += Math.abs(array[i] - array[i - 1]);
        }
        // 获取一个点，假设有A, B, C三个点，||AB| + |BC| - |AC||，其结果为0 or 正数，
        // 而这个正数就是进过B点所要多走的路程
        for (int i = 1; i + 1 < array.length; i++) {
            maxDis = Math.max(maxDis, Math.abs(array[i] - array[i - 1]) + Math.abs(array[i + 1] - array[i]) - Math.abs(array[i + 1] - array[i - 1]));
        }
        System.out.println(totalDis - maxDis);
    }
}
