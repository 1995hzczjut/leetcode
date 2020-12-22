package com.leetcode.collectionsTest.HashMapTest;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Key对象。为了验证treeify过程，人为控制hashcode函数。
 *
 * @author Zhancong Huang
 * @date 23:09 2018/10/9
 */
public class MapKey {

    private String key;

    private static final String REG = "[0-9]+";

    public MapKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MapKey anotherMapKey = (MapKey) o;
        if (key == null) {
            return anotherMapKey.key == null;
        } else {
            return key.equals(anotherMapKey.key);
        }
    }

    @Override
    public int hashCode() {
        if (key == null) {
            return 0;
        }

        Pattern pattern = Pattern.compile(REG);
        if (pattern.matcher(key).matches()) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public String toString() {
        return key;
    }
}
