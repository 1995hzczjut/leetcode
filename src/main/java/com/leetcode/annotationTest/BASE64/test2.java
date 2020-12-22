package com.leetcode.annotationTest.BASE64;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Zhancong Huang
 * @date 18:55 2019/1/15
 */
public class test2 {

    static Random random = new Random();

    public static void predict() throws Exception {
        try (Graph graph = new Graph()) {
            graph.importGraphDef(Files.readAllBytes(Paths.get(
                    "C:\\Users\\hzc\\Desktop\\model.pb"
            )));
            try (Session sess = new Session(graph)) {
                // 自己构造一个输入
                float[][] input = new float[1][100];
                for (int i = 0; i < 100; i++) {
                    input[0][i] = random.nextInt(10);
                }
                try (Tensor x = Tensor.create(input);
                     // input是输入的name，output是输出的name
                     Tensor y = sess.runner().feed("dense_1_input", x).fetch("output").run().get(0)) {
                    float[][] result = new float[1][(int)y.shape()[1]];
                    y.copyTo(result);
//                    System.out.println(Arrays.toString(y.shape()));
//                    System.out.println(Arrays.toString(result[0]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long time1 = System.currentTimeMillis();
        int i = 0;
        while (i < 1000){
            i++;
            predict();
        }
        predict();
        System.out.println((System.currentTimeMillis() - time1)/1000);
    }

}
