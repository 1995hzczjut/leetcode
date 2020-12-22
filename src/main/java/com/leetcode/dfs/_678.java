package com.leetcode.dfs;

public class _678 {

    /**
     * 考虑没有通配符的情况，与之前另一道题目相似：
     * 一个只有小括号表达式从左到右写，如果某个时刻（的数量小于）的数量，后续的都不用写了，因为永远不可能合法了
     * 这个问题背景不知道，永远做不出
     */
    public boolean checkValidStringWithoutStar(String s, int start, int count) {
        if (count < 0) return false;
        if (start == s.length()) {
            return count == 0;
        }
        if (s.charAt(start) == '(') {
            return checkValidStringWithoutStar(s, start + 1, count + 1);
        } else {
            return checkValidStringWithoutStar(s, start + 1, count - 1);
        }
    }


    /**
     * 考虑右通配符的情况。因为每次递归看的都是start指向的字符，所以多了个else分支而已
     */
    public boolean checkValidStringWithStar(String s, int start, int count) {
        if (count < 0) return false;
        if (start == s.length()) {
            return count == 0;
        }
        if (s.charAt(start) == '(') {
            return checkValidStringWithStar(s, start + 1, count + 1);
        } else if (s.charAt(start) == ')') {
            return checkValidStringWithStar(s, start + 1, count - 1);
        } else {
            return checkValidStringWithStar(s, start + 1, count)     //看成空格
                    || checkValidStringWithStar(s, start + 1, count - 1)
                    || checkValidStringWithStar(s, start + 1, count + 1);
        }
    }

    public boolean checkValidString(String s) {
        return checkValidStringWithStar(s, 0, 0);
    }

    public static void main(String[] args) {
        _678 s = new _678();
        System.out.println(s.checkValidString("(*))"));
    }
}
