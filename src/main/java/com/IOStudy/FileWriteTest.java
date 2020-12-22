package com.IOStudy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zhancong Huang
 * @date 19:39 2019/4/25
 */
public class FileWriteTest {
    public static void main(String[] args) throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("aaa.txt").getPath();
        //path:D:/javaproject/leetcode_hzc/target/classes/aaa.txt 是打包后的地方，不是当前resource。
        //要写在左边的文件只能绝对路径了
        System.out.println(path);
        //pw自动flush缓冲区的功能.
        PrintWriter pw = new PrintWriter(new FileWriter(path, true));
        for (int i = 0; i < 5; i++) {
            //不换行
//            pw.write("ccc");
            //自动换行
            pw.println("ccc");
        }
        pw.close();
    }
}
