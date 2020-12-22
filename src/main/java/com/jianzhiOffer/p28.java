package com.jianzhiOffer;

/**
 * 跟169不一样，最后怎么验证时没想到的。其实找3歌数字的也要验证
 * 最后count不是max出现的次数
 *
 * @author Zhancong Huang
 * @date 19:02 2019/4/21
 */
public class p28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int num = 0, count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
            } else {
                count = array[i] == num ? count + 1 : count - 1;
            }
        }
        //由于此题不保证最后一定存在，需要验证，复杂度依然时O（N）
        //错误：第二次做的时候下面这段没加，题目给的CASE就可以看到最后结束如果存在，cnt也并不是max出现的次数
        //例如题目的CASE，最后num=2,但cnt=2,这是由LC169算法本身决定的
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) count++;
        }
        return count > array.length / 2 ? num : 0;
    }
}
