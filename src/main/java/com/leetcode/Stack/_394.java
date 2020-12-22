package com.leetcode.Stack;

import java.util.ArrayDeque;

/**
 * while(i-- > 0)这种不要再用了，老忘记退出时i已经是-1了
 * hard级别了
 *
 * @author Zhancong Huang
 * @date 23:08 2019/6/8
 */
public class _394 {

    public String decodeString(String s) {
        return helper(s, 0, s.length() - 1);
    }

    /**
     * 小问题：
     * （1）字符串流的形式转为数字，123，挨个读取*10+下一个
     * （2）[ ]位置的细节
     */
    private String helper(String s, int start, int end) {
        StringBuilder result = new StringBuilder();
        int i = start;
        int curNum = 0;
        //老错误，<=s.length()
        while (i <= end) {
            if (Character.isDigit(s.charAt(i))) {
                curNum = curNum * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                int flag = 0, innerStart = ++i;
                while (i <= end) {
                    if (s.charAt(i) == '[') {
                        flag++;
                    } else if (s.charAt(i) == ']') {
                        if (flag == 0) {
                            break;
                        } else {
                            flag--;
                        }
                    }
                    i++;
                }
                String inner = helper(s, innerStart, i - 1);
                while (curNum > 0) {
                    result.append(inner);
                    curNum--;
                }
            } else {
                result.append(s.charAt(i));
            }
            i++;
        }
        return result.toString();
    }

}
