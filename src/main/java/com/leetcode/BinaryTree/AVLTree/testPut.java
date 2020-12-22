package com.leetcode.BinaryTree.AVLTree;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * 测试。代替junit
 * 与Treemap比较插入
 *
 * @author Zhancong Huang
 * @date 12:08 2018/10/8
 */
public class testPut {
    static Random random = new Random();
    static int MAX1 = 65535;

    public static void main(String[] args) {
        AVLMap<Integer, String> map = new AVLMap<>();
        TreeMap<Integer, String> map1 = new TreeMap<>();

        for (int i = 0; i < MAX1; ++i) {
            int key = random.nextInt(MAX1);
            map.put(key, String.valueOf(key));
            map1.put(key, String.valueOf(key));
        }
        //testput(map, map1);
        //testget(map);
        //testFirstAndLast(map);
        testLevelOrder();

    }

    private static void testLevelOrder() {
        AVLMap<Integer, String> map = new AVLMap<>();
        for (int i = 0; i <= 16; i++) {
            int key = random.nextInt(16);
            map.put(key, String.valueOf(key));
        }
        map.levelOrder();
        System.out.println("===========");
        for(int i = 16; i >= 0; i--){
            if(i % 2 == 0){
                map.remove(i);
            }
        }
        map.levelOrder();
    }

    private static void testFirstAndLast(AVLMap<Integer, String> map) {
        //System.out.println("first: " + map.getFirstEntry().key);
        //System.out.println("last: " + map.getLastEntry().key);
    }

    private static void testget(AVLMap<Integer, String> map) {
        map.put(655, "AAA");
        System.out.println(map.get(655));
    }


    private static void testput(AVLMap<Integer, String> map, TreeMap<Integer, String> map1) {
        //泛型使用不是很熟练。外面不能出现K,V
        Iterator<AVLEntry<Integer, String>> iterator = map.iterator();
        //Treemap没有实现迭代器接口。是内部类EntrySet实现的。
        Iterator<Map.Entry<Integer, String>> iterator1 = map1.entrySet().iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().key.equals(iterator1.next().getKey())) {
                System.out.println("与treemap不一致");
                break;
            }
        }
        System.out.println("success");
    }
}
