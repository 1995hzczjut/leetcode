package com.exem.past;

/**
 *  helper(1) = helper(2) / 4 * 5 + 1
 *
 *  中间整除失败就退出
 *
 *
 *
 *
 * @author Zhancong Huang
 * @date 15:22 2019/9/10
 */
public class MainDahua {

    public static void getAns(){
        int[] result = new int[1];
        //这个for循环就是用来选出第五个人吃之前的数量
        for (int i = 6; i < Integer.MAX_VALUE; i++) {
            if ((i - 1) % 5 == 0 && helper(result, 1, i)){
                System.out.println("i: " + i);
                System.out.println(result[0]);
                break;
            }
        }
    }

    /**
     * 返回第n个人吃前有的食物总数，如果中间遇到整除失败，就返回false
     *
     * @param result 结果参数，就是第n个人吃前有的食物总数
     * @param n 第几个人
     * @param init 初始值，第5个人吃之前剩下的数量，从1到无穷大测试的
     * @return
     */
    private static boolean helper(int[] result, int n, int init){
        if (n == 5) {
            result[0] = init;
            return true;
        }
        int[] tmp = new int[1];
        //递归调用，
        boolean nextResult = helper(tmp, n + 1, init);
        if (!nextResult || tmp[0] % 4 != 0){
            return false;
        }
        result[0] = (tmp[0] / 4) * 5 + 1;
        return true;
    }


    public static void verify(int init){
        int num = init;
        for (int i = 5; i > 0; i--) {
            System.out.println("第" + i+ "次之前有： " + num);
            num = (num / 4) * 5 + 1;
        }
    }

    public static void main(String[] args) {
        //getAns();
        //verify(1276);
    }
}
