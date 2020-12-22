package com.leetcode.array;



/**
 * https://leetcode.com/problems/next-permutation/discuss/13865/Sharing-my-clean-and-easy-understand-java-code-with-explanation
 * 6 3 4 9 8 7 1
 * 一个成熟的算法。321 这样的next p... 是123.
 * 1.26补充：【重要前提】首先一个数字全是降序，6543210这种，是没有下一个值的，只有至少存在两个相邻的数组，是升序才有可能。
 * 例如 6534210  想要得到尽可能接近原数字的值，只能努力调整低位，因此从右往左找第一次出现的升序。
 * 找到34，此时可以把65先忽略，只看34210，因为34是第一个出现的升序，因此保证3的后面全部降序【全部降序没有变大的可能了】，
 * 为了【最小的增大】34210，只有找3右边最小的比3大的数字过来，跟3换，找到4.此时变为43210.
 * 此时654固定，但是后面的3210还有变小的可能，而且应该尽可能小。由于这串数字保证降序，要尽量小，reverse即可
 * 2.22补充，上面例子不好，为什么反转看6349871
 * 看49871 为了最小的增大，4后面找到7.重要的一点：换完后，79841中9841保证降序，可以简单的证明。
 * 为了整体最小的增大，【高位已经换完了即4，4后面的序列无论怎么打打乱也比之前的大了】，因此4后面的应该最小，
 * 对于一个降序序列要变小，最简单不过了，直接反转。这就是最后要反转的理由
 *
 * @author Zhancong Huang
 * @date 21:13 2018/10/3
 */
public class _31 {

    /**
     * 2.22改动：同样引入数值包装类，用null代表没有更新过这个语义
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Integer idx = findIdx(nums);
        swap(nums, idx);
        reverse(nums, idx);
    }

    private void reverse(int[] nums, Integer idx) {
        int start = idx == null ? 0 : idx + 1;
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 从右边开始找到第一个大于idx指的数字的数，并交换
     */
    private void swap(int[] nums, Integer idx) {
        if (idx == null) {
            return;
        }
        for (int i = nums.length - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                //记得直接break,不能换两次
                break;
            }
        }
    }

    /**
     * 从右边开始找到数组中第一次升序的左边数字
     * 输入已经保证了有两个，找不到返回NULL,即1234这种升序数字
     */
    private Integer findIdx(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return null;
    }

}
