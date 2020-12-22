package com.leetcode.math;



/**
 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 * 坑在于外面两个for循环的顺序一定要模拟原始的乘法相称，不然会出现奇怪的结果
 *
 * @author Zhancong Huang
 * @date 21:00 2019/10/18
 */
public class _43 {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int[] retArr = new int[num1.length() + num2.length()];
        //开始想当然的写法。123*456就出现错误的结果
//        for (int i = 0; i < num1.length(); i++) {
//            for (int j = 0; j < num2.length(); j++) {

        //严格按照乘法法则
        for (int j = num2.length() - 1; j >= 0; j--) {
            for (int i = num1.length() - 1; i >= 0; i--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                tmp += (retArr[i + j] * 10 + retArr[i + j + 1]);
                retArr[i + j + 1] = tmp % 10;
                retArr[i + j] = tmp / 10;
            }
        }

        StringBuilder retSb = new StringBuilder();
        for (int i = 0; i < retArr.length; i++) {
            //数字矩阵转字符串，处理leading zero问题
            if (retSb.length() == 0 && retArr[i] == 0) continue;
            retSb.append(String.valueOf(retArr[i]));
        }
        return retSb.toString();
    }

    public static void main(String[] args) {
//        //这一步括号内的“a”先在常量池创建。然后s1指向堆。堆和常量池不同的对象。
//        String s1 = new String("a");
//        //此时常量池里已有,这行无效
//        s1.intern();
//        //拿常量池里的对象的引用
//        String s2 = "a";
//        //两个不一样的地址，返回false
//        System.out.println(s1 == s2);


        //true
        //字节码调用Stringbuffer。toString.不会去
//        String s1 = new String("a") + new String("b");
//        s1.intern();
//        String s2 = "ab";
//        System.out.println(s1 == s2);


//        StringBuilder sb = new StringBuilder();
//        sb.append("a");
//        sb.append("b");
//        String s1 = sb.toString();
//        s1.intern();
//        String s2 = "ab";
//        System.out.println(s1 == s2);



//        String s2 = "ab";
//        System.out.println(s1 == s2);


        String s1 = "aa";
        String s2 = new String("aa");
        System.out.println(s1 == s2);

    }

}
