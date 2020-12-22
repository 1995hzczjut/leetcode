package com.jianzhiOffer;

import java.util.Objects;

/**
 * @author Zhancong Huang
 * @date 19:35 2019/4/16
 */
public class p1 {
    public boolean Find(int target, int[][] array) {
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target){
                return true;
            }else if(array[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}

