package com.leetcode.dateformat;

import jdk.internal.dynalink.beans.StaticClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat 有线程安全问题，又不需要共享，选择threadlocal
 * @author Zhancong Huang
 * @date 14:32 2019/1/11
 */
public class ThreadLocalSDFUtil {
    //Java8
    private static ThreadLocal<SimpleDateFormat> DATEFOTMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static String format(Date date){
        return DATEFOTMAT.get().format(date);
    }


}
