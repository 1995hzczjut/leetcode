package com.leetcode.array;

/**
 * 看清楚modify 不是 exchange.贪心问题，
 * 从左往右遍历，每个数比较前一个数，发现比前一个小，就要更新，问题是更新哪个？
 * 贪心的做法是尽量调整前一个，具体看下面的case。
 *
 * @author Zhancong Huang
 * @date 14:45 2019/1/13
 */
public class _665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                //按照上面的做法，这里必须处理了
                //142 342 42 i都在2的地方
                //142: 调整可以选择4变小，2变大。但是2后面未知。贪心的做法肯定调整4，因为把2变大可能
                //      会影响2后面的，且4变小应该尽力变小，即变成1
                //242: 也是调整4
                //342；只能调整2了。2大于等于4即可..
                //42： 4前面没了。换4好一点。
                if (i == 1) {
                    //42
                    nums[i - 1] = nums[i];
                } else if (nums[i - 2] <= nums[i]) {
                    //142 242.修改4，这里也是贪心，把4降到最低，方便后面查看，最低是1
                    nums[i - 1] = nums[i - 2];
                } else if (nums[i - 2] > nums[i]) {
                    //342.只能提升2，提升也要最小程度的提升，所以2变为3
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count < 2;
    }
}
