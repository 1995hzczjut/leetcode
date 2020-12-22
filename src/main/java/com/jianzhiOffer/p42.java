package com.jianzhiOffer;


import java.util.ArrayList;

/**
 * twoSUM SORTED问题
 * a a+1 a+2 a+3 =》 a*(a+3) < (a+1)*(a+2) =>》 a无论正负上述都成立
 * 所以要找的就是最外面的两个指针，和位sum。
 * 上面是推导出来的，但是找到所有合法的两个数字也不能忘，参考LC15
 * LC15还要求找到不重复的，更难
 *
 * @author Zhancong Huang
 * @date 10:11 2019/4/23
 */
public class p42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int left = 0, right = array.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (left < right) {
            if (array[left] + array[right] == sum) {
                result.add(array[left]);
                result.add(array[right]);
                break;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
