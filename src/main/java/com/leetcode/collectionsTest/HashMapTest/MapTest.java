package com.leetcode.collectionsTest.HashMapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Zhancong Huang
 * @date 23:23 2018/10/9
 */
public class MapTest {
    public static void main(String[] args) {
        Map<MapKey,String> map = new HashMap<MapKey, String>();

        //第一阶段.没有扩容。数组长度16
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }



        //第二阶段.没有超过12的阈值，但是单个桶长度大于8了，不需要树化，直接扩容到64 = 48 / 0.75.
        for (int i = 0; i < 10; i++) {
            //map.put(new MapKey(String.valueOf(i)), "A");
        }



        //第三阶段.超过48的阈值，数组长度64==》128。同时树化
        for (int i = 0; i < 50; i++) {
            //map.put(new MapKey(String.valueOf(i)), "A");
        }


        /*
        //第四阶段
        map.put(new MapKey("X"), "B");
        map.put(new MapKey("Y"), "B");
        map.put(new MapKey("Z"), "B");
        */
        //System.out.println(map);

        //正确遍历方式
        Iterator<Map.Entry<MapKey,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //简化版
        for(Map.Entry<MapKey,String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
