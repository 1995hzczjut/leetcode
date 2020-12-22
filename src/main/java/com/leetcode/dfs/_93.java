package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        helper1(new StringBuilder(), 0, result, s, 0);
        return result;
    }

    /**
     * 先画图，发现可以套模板，思考剪枝
     */
    private void helper1(StringBuilder tmp, int start, List<String> result, String s, int count) {
        if (count == 4 && start == s.length()) {
            result.add(tmp.toString());
            return;
        }
        //剪枝忘记写了
        if (count == 4) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            //可能s.substring(start, start + i + 1)出现越界
            if (start + i + 1 <= s.length()) {
                String subString = s.substring(start, start + i + 1);
                //subString的数字符合IP规范，首先不能以0开头，且大小小于等于255
                if (check(subString)) {
                    subString += count < 3 ? "." : "";
                    tmp.append(subString);
                    helper1(tmp, start + i + 1, result, s, count + 1);
                    tmp.delete(tmp.length() - subString.length(), tmp.length());
                }
            }
        }
    }

    private boolean check(String subString) {
        //1.0.0.255 是合法的
        if (subString.length() == 1){
            return true;
        }
        //中间一段不是单个数字，但是以0开头例如， 1.0.011.022 是不合法的
        if (!subString.startsWith("0") && Integer.parseInt(subString) <= 255){
            return true;
        }
        return false;
    }
}
