package com.yuanfudao;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 双栈排序
 * https://www.nowcoder.com/questionTerminal/d0d0cddc1489476da6b782a6301e7dec
 *
 * @author Zhancong Huang
 * @date 17:56 2019/11/2
 */
public class 双栈排序 {

    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) return new ArrayList<>();

        ArrayDeque<Integer> initStack = new ArrayDeque<>();
        ArrayDeque<Integer> sortedStack = new ArrayDeque<>();


        for (int num : numbers) {
            initStack.push(num);
        }

        while (!initStack.isEmpty()) {
            int tmp = initStack.pop();
            int polledNum = 0;
            while ((sortedStack.isEmpty() || sortedStack.peek() > tmp) && !sortedStack.isEmpty()) {
                polledNum++;
                initStack.push(sortedStack.pop());
            }
            sortedStack.push(tmp);
            while (polledNum-- > 0) {
                sortedStack.push(initStack.pop());
            }
        }
        return new ArrayList<>(sortedStack);
    }

    public static void main(String[] args) {
        System.out.println(twoStacksSort(new int[]{1, 2, 3, 4, 5}));
    }
}
