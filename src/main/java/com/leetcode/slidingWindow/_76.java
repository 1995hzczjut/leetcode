package com.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑窗前提：大的窗口不合法，小的必然不合法；小的合法，大的必然合法。
 * 时间复杂度有要求，参考第四题还是第三题.
 * https://leetcode.com/articles/minimum-window-substring/
 * 难在时间复杂度，按照之前的做法，永远有个case是过不了的，在判断包含的方法里面复杂度超了
 * 方法是用一个变量formed保存窗口有多少个字符跟t一样，初始是0，一个字符匹配了+1
 * 特别注意，合法的窗口应该包含t，例如t有2个A，2个B，窗口可以有3个A，2个B
 * formed就代表{sum(c)|窗口C的数量>t}
 * 所以窗口扩增时，formed+1的条件是t也有c,然后两者数量相等，而不是大于等于，这样会重复增加
 * 窗口压缩同理，是小于
 *
 * @author Zhancong Huang
 * @date 16:53 2020/4/15
 */
public class _76 {

    public static String minWindow1(String s, String t) {
        int left = 0, right = 0;
        int retLeft = 0, retRight = 0;
        Integer minWindowLength = null;
        Map<Character, Integer> windowMap = new HashMap<>(256);
        final Map<Character, Integer> T_MAP = new HashMap<>(256);
        int formed = 0;
        int required = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            T_MAP.put(c, T_MAP.getOrDefault(c, 0) + 1);
        }
        required = T_MAP.size();

        for (; right < s.length(); right++) {
            //修改代表这个窗口信息的变量
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            //formed代表匹配上的字符数，c可能匹配上首先要T_MAP包含c，还要处理重复包含的情况，即一个有4个A，一个有3个A
            if (T_MAP.containsKey(c) && T_MAP.get(c).equals(windowMap.get(c))) {
                formed++;
            }

            //窗口不合法，跳过
            if (formed != required) continue;

            //窗口合法，压缩
            while (left <= right && formed == required) {
                if (minWindowLength == null || minWindowLength > right - left + 1) {
                    retLeft = left;
                    retRight = right;
                    minWindowLength = right - left + 1;
                }
                //准备压缩左指针，处理相关变量
                char leftCharacter = s.charAt(left);
                windowMap.put(leftCharacter, windowMap.get(leftCharacter) - 1);
                //修改formed，formed变动只有如下情况:
                //T_MAP首先要有leftCharacter，然后windowMap少了一个字符后，总的字符出现的次数小于T_MAP
                if (T_MAP.containsKey(leftCharacter) && T_MAP.get(leftCharacter) > windowMap.get(leftCharacter)) {
                    formed--;
                }
                left++;

            }
        }
        if (minWindowLength == null) return "";
        else return s.substring(retLeft, retRight + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow1(s,t));
    }
}
