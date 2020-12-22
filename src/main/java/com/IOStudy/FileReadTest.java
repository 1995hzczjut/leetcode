package com.IOStudy;

import java.io.*;

/**
 * 读文件例子
 *
 * @author Zhancong Huang
 * @date 17:43 2019/4/25
 */
public class FileReadTest {

    /**
     * 最好改为try-catch-finally
     */
    public static void main(String[] args) throws IOException {
        //FileInputStream fi = new FileInputStream( FileReadTest.class.getResource("").getPath() +"aaa.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fi));
        BufferedReader br = new BufferedReader(new InputStreamReader(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("aaa.txt")));

        String str = null;
        //不要写成-1
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        //记得关闭
        //fi.close();
        br.close();
    }

}
