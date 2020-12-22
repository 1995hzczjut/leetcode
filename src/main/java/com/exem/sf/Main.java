package com.exem.sf;

/**
 * 找最长回文子串
 *
 * 学生表（id,name）
 * 数学科目（id,score）
 * id关联
 * 排名表（id,score,name,rank）
 * 相同分数排名一样
 *
 * create tb as
 * select
 *  s.id, m.score, s.name, (select count(distinct m2.score) + 1 from stu s2, math m2 where s.id != s2.id and s2.id = m2.id and m2.score > m.score)
 * from
 *  stu s, math m
 * where
 *  s.id = m.id
 *
 *
 *
 *
 *
 *
 * @author Zhancong Huang
 * @date 15:07 2019/12/19
 */
public class Main {

    public static String helper(String string) {
        boolean[][] dp = new boolean[string.length()][string.length()];
        String ret = "";

        for (int i = string.length(); i >= 0; i--) {
            for (int j = i; j < string.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j - 1) {
                    dp[i][j] = string.charAt(i) == string.charAt(j);
                } else {
                    dp[i][j] = string.charAt(i) == string.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && j - i + 1 > ret.length()) {
                    ret = string.substring(i, j + 1);
                }
            }
        }

        return ret;
    }
    private static void testHelper() {
        //        String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
//       //String s = "abababa";
//        System.out.println(s.length());
//        String r = helper(s);
//        System.out.println(r.length());
//        System.out.println(r);
    }

    public static void main(String[] args) {


    }



}
