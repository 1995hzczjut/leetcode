package com.leetcode.BigData.problem1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * 大文件存的是ip，有重复。找出现次数最多的100个。
 * 思路：hash（保证相同的IP一定在相同的文件,没有这个性质也做不下去）+分而治之，去小文件里找前100（只能是100）.最后再合并
 * 额外：treeset tremap。 可用在构造函数传入一个比较器对象，
 * 也可以让要加入的对象实现比较器接口，这样用无参构造也OK。
 * 对IP封装成对象这种思路也要有。也可以用Treemap，插入前先检查containsKey，不存在才插，存在就累计。
 */
class IP implements Comparable<IP> {

    private String IP;
    public int nums;

    IP(String IP, int nums) {
        this.IP = IP;
        this.nums = nums;
    }

    //主要是返回0的时候的处理。通过外部比较器中重写compare方法，判断其返回值来确定排序位置，判断结果有三种：（一）大于0，（二）小于0，（三）等于0；。
    // 大于0时，表示o1比o2大，因此要排在后面，，小于0时，表示o1比o2小，因此要排在前面，等于0时，集合会认为二者相等，即已经存在此元素了，不再存储
    //但是可用把两个合并
    @Override
    public int compareTo(IP o) {
        if (this.nums > o.nums) {
            return 1;
        } else if (this.nums < o.nums) {
            return -1;
        } else {
            //比较器返回0，是不处理的。但是可以在这里把nums合并
            //比较巧妙的处理
            this.nums += o.nums;
            return 0;
        }
    }
}


public class Solution {
    //用treemap,hashmap+排序 也能解决问题
    private Set<IP> resultSet = new TreeSet<>();


    //处理一个小文件。1000个文件，for好了
    public void analysis(File logfile) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(logfile));
        Set<IP> tempSet1 = new TreeSet<>();//存期当前小文件
        String ip = bufferedReader.readLine();
        while(ip != null){
            tempSet1.add(new IP(ip,1));
        }
        bufferedReader.close();
        //最后结果与当前小文件前100合并
        int i = 1;
        for(IP o : tempSet1){
            this.resultSet.add(o);
            //执行这个语句前，i等于几就是上面执行了几次
            if(i > 100){
                break;
            }
            i++;
        }
        //取上一步结果中的前100
        i = 1;
        Set<IP> tempSet2 = new TreeSet<>();
        for(IP o : this.resultSet){
            tempSet1.add(o);
            if(i > 100){
                break;
            }
            i++;
        }

        this.resultSet = tempSet2;
        tempSet1 = null;
        tempSet2 = null;
    }

    public static void main(String[] args) {
        String a = new String(new int[]{65537},0,1);
        System.out.println(a.toCharArray().length);
        System.out.println(a);
    }
}
