package com.leetcode.annotationTest.BASE64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.util.Arrays;

/**
 * @author Zhancong Huang
 * @date 23:59 2019/1/14
 */
public class util {

    public static String GetImageStr(String path) {
        String imgFile = path;
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * @Description： base64字符串转化成图片
     * @param: imgStr
     * @Return:
     */
    public static boolean GenerateImage(String imgStr, String imagePath, String photoname) {
        if (imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(imgStr);
            //生成jpeg图片
            String imgFilePath = imagePath + photoname;
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int[][] getImage(String path) {
        File file = new File(path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
            System.err.println(img.getType());
            int width = img.getWidth();
            int height = img.getHeight();
            int[][] imgArr = new int[width][height];
            Raster raster = img.getData();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int rgb = img.getRGB(i, j);
                    //imgArr[i][j] = raster.getSample(i, j, 0);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = (rgb & 0xFF);
                    imgArr[i][j] = (r*299 + g*587 + b*114 + 500) / 1000;
                }
            }
            return imgArr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        String pic = GetImageStr("C:\\Users\\hzc\\Desktop\\织物数据\\pic1.jpg");
//        String pic = GetImageStr("C:\\Users\\hzc\\Desktop\\微信图片_20181217204359.png");
//        System.out.println(pic.length());
//        long time2 = System.currentTimeMillis();
//        System.out.println(pic);
//        System.out.println(time2 - time1);
        //GenerateImage(pic,"C:\\Users\\hzc\\Desktop\\织物数据\\", "pic2.png" );
        //System.out.println(System.currentTimeMillis() - time1);
        int[][] iamge = getImage("C:\\Users\\hzc\\Desktop\\织物数据\\pic1.jpg");
//        System.out.println(System.currentTimeMillis() - time1);
//        System.out.println(iamge.length);
//        System.out.println(iamge[0].length);
        System.out.println(Arrays.deepToString(iamge));


    }
}
