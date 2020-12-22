package com.leetcode.array;

/**
 * 找出一个数组中出现次数超过一半的那个数,也要背思路的
 * 方法 两个变量，count, element. 遍历，如果是当前element, count++. 否则--。 等于0了换一个数
 * 证明： 存在性： 用x个x,y个y,z个z模拟最坏的情况
 *        唯一性： 简单
 *
 *  简单的解释：这个叫摩尔投票发，如果计数器减到了0，当前数字已经很弱了，需要换一个
 *  且先验条件保证 最后留下的数必定在前面出现过
 * @author Zhancong Huang
 * @date 18:51 2018/11/13
 */
public class _169 {
    public  int majorityElement(int[] nums) {
        int count = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                cur = nums[i];
                count++;  //起始为1
            }else{
                count = (nums[i] == cur) ? count + 1 : count - 1;
            }
        }
        return cur;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,1,1,1,3,3,3,4};
        System.out.println(new _169().majorityElement(nums));
    }
}
