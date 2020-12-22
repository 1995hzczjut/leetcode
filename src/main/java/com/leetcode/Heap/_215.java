package com.leetcode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * TOP k 系列问题。
 * 注意 K代表 第K大
 *
 * @author Zhancong Huang
 * @date 22:41 2018/9/8
 */
public class _215 {

    /**
     * 使用堆，看成动态处理的过程。堆的元素数量保持k个，即一直选取当前序列的最大的k个。最后返回peek就是了
     * 最简单，但是在nums超过内存时确实有用的，Nums流一样的加入堆。
     */
    public int findKthLargest0(int[] nums, int k) {
        //用小根堆。如果要返回最小的几个，那就用大根堆
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 时间复杂度O（N）
     */
    public static int partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        //跳出的时候l 是中间等于P部分最右边的右边一个
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, l++, ++less);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        //-1
        return l - 1;
    }

    //这种做法好的情况就是，一次就中，O（n）
    //最差 一直到最优left = rigth 才给出结果。n + n-1 + n-2 + ...  O(n^2)
    public static int helper1(int[] nums, int left, int right, int k) {
        int partitionResult = partition(nums, left, right, nums[right]);
        int m = right - partitionResult;
        if (m == k - 1) {
            return nums[partitionResult];
        } else if (m < k - 1) {
            return helper1(nums, left, partitionResult - 1, k - m - 1);
        } else {
            return helper1(nums, partitionResult + 1, right, k);
        }
    }



    //思路以前网上看到过。补漏洞法。
    public static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i > 1; i--) {
            int newNumIndex = random.nextInt(i - 1);
            swap(nums, i, newNumIndex);
        }
    }

    //网上给的优化方法是，打乱输入nums（快排思想）。 时间就是O（常数 * n）= O(n)
    public static int findKthLargest2(int[] nums, int k) {
        shuffle(nums);
        return helper1(nums, 0, nums.length - 1, k);
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4, 6, 5};
//        shuffle(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(partition(a, 0, a.length - 1, 4));
        System.out.println(Arrays.toString(a));
//        System.out.println(findKthLargest2(a, 4));

    }
}
