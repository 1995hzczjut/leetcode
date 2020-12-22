package com.leetcode.collectionsTest.HashMapTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Zhancong Huang
 * @date 10:52 2018/10/11
 */
public class PythonTest {
    public static void main(String[] args) {
        String[] arguments = new String[] {"python", "D:\\pythonJava\\test.py", "huzhiwei", "25"};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
