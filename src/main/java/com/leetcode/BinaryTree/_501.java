package com.leetcode.BinaryTree;

import com.leetcode.dfs.ListNode;

import java.util.*;

/**
 * 栈遍历 + 在线处理
 *
 * @author Zhancong Huang
 * @date 10:42 2018/12/14
 */
public class _501 {


    /**
     * 前置问题：找出一个数组（有重复元素）中出现次数最多的数字
     * 1223444555
     * 错的！！！11221
     */
    public List<Integer> findModeInArray(int[] arr) {
        //========以下是for循环中第i个数字处理结束后的变量意义=======
        //[0,i]的出现次数最多的数字的次数
        int maxCnt = 0;
        //第i个数
        Integer prevNum = null;
        //第i个数出现的次数
        int curCnt = 0;
        //[0,i]的出现次数最多的数字集合
        List<Integer> result = new LinkedList<>();
        //========每次处理都保证上面的结果，最后个数字处理后的result就是我们要的=======

        for (int i = 0; i < arr.length; i++) {
            if (prevNum == null || arr[i] != prevNum) {
                curCnt = 1;
            } else {
                curCnt++;
            }
            //确定[0,i]区间的出现次数最多的数字
            if (curCnt > maxCnt) {
                result.clear();
                result.add(arr[i]);
                maxCnt = curCnt;
            } else if (curCnt == maxCnt) {
                result.add(arr[i]);
            }
            prevNum = arr[i];
        }
        return result;
    }

    /**
     * 基于findModeInArray
     */
    public int[] findMode(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        int maxCount = 0;
        int curCount = 0;
        //不再需要标志位控制是否第一次读到Node
        Integer prev = null;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //cur = null 代表这个左子树没了。按照先序拿到父节点
                cur = stack.pop();
                //process online
                if (prev == null || cur.val != prev) {
                    curCount = 1;
                } else {
                    curCount++;
                }
                if (curCount > maxCount) {
                    resultList.clear();
                    resultList.add(cur.val);
                    maxCount = curCount;
                } else if (curCount == maxCount) {
                    resultList.add(cur.val);
                }
                prev = cur.val;
                //父节点处理完了，处理右子树。递归处理,cur指针指过去再循环开始就可以了
                cur = cur.right;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _501().findModeInArray(new int[]{1, 1, 2, 2,1}));
    }

}
