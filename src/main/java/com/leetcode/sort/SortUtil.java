package com.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Zhancong Huang
 * @date 10:14 2019/4/10
 */
public class SortUtil {


    /**
     * ===================插入排序=======================
     */

    /**
     * 要点：每次待插入的数字其前面保证有序，这里选择从后往前查看（链表的插入排序是从前往后）。指针的设置。
     */
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    /**
     * ===================希尔排序=======================
     */
    public static void shellSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //控制间隔 8，4，2，1，0
        for (int interval = nums.length / 2; interval > 0; interval /= 2) {
            //固定间隔的数保证有序
            for (int i = 0; i < nums.length; i++) {
                //终止条件的等号一开始忘记了
                for (int j = i; j >= interval; j -= interval) {
                    if (nums[j] < nums[j - interval]) {
                        swap(nums, j, j - interval);
                    }
                }
            }
        }
    }


    /**
     * ===================归并排序=======================
     */

    /**
     * 要点：
     * 递归时，temp和Nums搞混了，一定要注意递归时关注的是left到right 子数组。
     * merge 的过程可分分两步，但是one pass也能完成。
     * one pass 的条件只能这么写  左边越界||右边不越界&&大小关系
     * 右边的 右边不越界漏掉引发了意外。
     * 还是要多练（建议以后不要写one-pass太容易错了）
     * merge,要保证稳定，注意<=的情况,此时应该左边那一段的指针移动
     */
    public static void mergeSort(int[] nums) {
        mergeSort0(nums, 0, nums.length - 1);
    }

    private static void mergeSort0(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort0(nums, left, mid);
        mergeSort0(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        //merge,要保证稳定，注意<=的情况,此时应该左边那一段的指针移动
        int p = left, q = mid + 1, idx = 0;
        while (p <= mid && q <= right) {
            if (nums[p] <= nums[q]) {
                tmp[idx++] = nums[p++];
            } else {
                tmp[idx++] = nums[q++];
            }
        }
        while (p <= mid) {
            tmp[idx++] = nums[p++];
        }
        while (q <= right) {
            tmp[idx++] = nums[q++];
        }
        //写回原数组
        for (int i = 0; i < tmp.length; i++) {
            nums[i + left] = tmp[i];
        }
    }

    /**
     * ===================选择排序=======================
     */

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minNum = nums[i], minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minNum) {
                    minNum = nums[j];
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
    }


    /**
     * ===================冒泡排序=======================
     */

    public static void bubbleSort(int[] nums) {
        //i代表待确认的位数，从最后一位开始
        for (int i = nums.length - 1; i > 0; i--) {
            //这个循环结果找出[0,i]最大的，扔在i
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * ===================堆排序=======================
     */

    public static void heapSort(int[] nums) {
        heapInit(nums);
        //size后续会变，表示尚未OK的数组的长度
        int size = nums.length;
        //初始化后已经最大的已经在堆顶了
        swap(nums, 0, --size);
        while (size > 0) {
            heapify(nums, size);
            swap(nums, 0, --size);
        }
    }

    /**
     * 类似插入排序的过程，例如原始编号0123456，按从左到右的顺序处理，现在下标走到4
     * 那么下标0123已经构成合格的堆了，对于4，看其父节点(下标为1).如果4大于1，那么是不合法的，需要不断往上看
     * 如果4小于1，那么不用调整了。
     * 总体逻辑就是插入排序，大的顺序从左到右，小的顺序从右到左
     */
    private static void heapInit(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            //跟自己的父节点比大小。终止条件就是idx=0,父节点也是0
            while (nums[idx] > nums[(idx - 1) / 2]) {
                swap(nums, idx, (idx - 1) / 2);
                idx = (idx - 1) / 2;
            }
        }
    }

    /**
     * 这个方法的作用是尽可能把下标为0的点沉下去
     *
     * @param size 尚未OK的数组的长度
     */
    private static void heapify(int[] nums, int size) {
        int root = 0, left = 1, right = 2;
        //每次循环做的事情是判断当前点能不能跟它的孩子节点交换，循环终止的条件就是没有孩子节点了
        //所以以left为基准，但要注意可能left存在，而right不存在
        //以right为基准不行也是这个原因，right可能没了，而left还有
        while (left < size) {
            int maxIdx = (right >= size || nums[left] > nums[right]) ? left : right;
            if (nums[maxIdx] <= nums[root]) {
                break;
            }
            swap(nums, root, maxIdx);
            root = maxIdx;
            left = 2 * root + 1;
            right = 2 * root + 2;
        }
    }

    /**
     * ===================快速排序=======================
     */

    public static void quickSort(int[] nums) {
        quickSort0(nums, 0, nums.length - 1);
    }

    public static void quickSort0(int[] nums, int start, int end) {
        if (start >= end) return;
        //改进点，随机选择pivot.目的是防止出现近乎有序的数组，使得排序代价过大
        swap(nums, end, start + (new Random()).nextInt(end - start + 1));
        //改进点：一次partition分为三段
        int[] p = partition(nums, start, end, nums[end]);
        quickSort0(nums, start, p[0]);
        quickSort0(nums, p[1], end);
    }

    private static int[] partition(int[] nums, int start, int end, int target) {
        int less = start - 1, more = end + 1, idx = start;
        while (idx < more) {
            if (nums[idx] < target) {
                swap(nums, ++less, idx++);
            } else if (nums[idx] > target) {
                swap(nums, --more, idx);
            } else {
                idx++;
            }
        }
        int[] res = new int[2];
        res[0] = less;
        res[1] = more;
        return res;
    }


    /**
     * ===================数组交换======================
     */

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws InterruptedException {
        //int a[] = {2, 3, 4, -1, 0, 6};
        int a[] = {18, 24, 12, 15, 1, 27, 17, 19};
        quickSort(a);
        //Thread.sleep(100);
        System.out.println(Arrays.toString(a));

    }
}
