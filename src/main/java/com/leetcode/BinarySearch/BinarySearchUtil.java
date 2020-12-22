package com.leetcode.BinarySearch;

/**
 * 下面都是输出索引。
 * 两分问题一定要看清楚 是否有重复！！！
 * 无重复的直接再while里写 if (nums[mid] == target)
 */
public class BinarySearchUtil {

    /**
     * 对于数组没有重复值的两分搜索：
     * （1）while循环里可直接写nums[mid]=key时返回
     * （2）执行到while外面代表没有找到，返回-1
     */



    /**
     * =====下面的所有问题中数组都可能有重复值.且不保证key一定存在====
     * 注意点：
     * （1）rl卡住的位置，确定要返回r或者l
     * （2）等号情况就用key一个值代入
     * （3）返回rl可能要验证，也可能不用验证
     * （4）找不到时要单独处理，默认最后返回-1
     */

    /**
     * 查找第一个相等的元素
     */
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            System.out.println("findFirstEqual");
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //1 2 2 4 4  这种3 不存在
        //    r l       两个指针最后卡在这里，需要校验
        //array[left] 写下的时候就要考虑到越界，对应的情况是
        //  2  2  2  2  找3
        //           r l   l已经越界了
        if (left < array.length && array[left] == key) {
            return left;
        }
        return -1;
    }

    /**
     * 查找最后一个相等的元素
     */
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            System.out.println("findLastEqual");
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left + "," + right);
        //1 2 2 2.5 2.5 3.5 3.5 3.5
        //            r  l
        //  4  4  4  4
        //r l                r越界
        if (right > 0 && array[right] == key) {
            return right;
        }
        return -1;
    }

    /**
     * 查找最后一个等于或者小于key的元素
     */
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            System.out.println("findLastEqualSmaller");
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //2222333333444
        //         rl
        //找不到的情况  44444
        //             rl        r正好位于-1，所以不需要再验证了
        //等于的情况就是用3代入，3是我们要的结果，所以等于时l动
        return right;
    }


    /**
     * 查找最后一个小于key的元素
     */
    static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            System.out.println("findLastSmaller");
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //于的情况就是用3代入，3不是我们要的结果，所以等于时r动
        return right;
    }

    /**
     * 查找第一个大于key的元素
     */
    public static int findFirstLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            System.out.println("findFirstLarger");
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 3, 3, 3, 3, 3};
        //System.out.println(findFirstEqual(a,3));
        System.out.println(findFirstLarger(a, 0));
        System.out.println(a.length);
    }


}
