package com.leetcode.annotationTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author Zhancong Huang
 * @date 19:41 2018/12/31
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        System.out.println(sc.connect(new InetSocketAddress("localhost", 8001)));  //半连接
        Selector selector = Selector.open();
        sc.register(selector, SelectionKey.OP_CONNECT);
        selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        sc.finishConnect();
        //sc.register(selector, SelectionKey.OP_WRITE);  只有这个才成功
        //sc.register(selector, SelectionKey.OP_READ);  阻塞
        //sc.register(selector, SelectionKey.OP_CONNECT); readOps=0,但是select依然可以select到。
        //finishConnect 之后管道已经连接OK了。这时候如果还是对OP_CONNECT感兴趣，则可以select到（选择器认为这是一个新事件），但是ReadOPS=0,一个isXXXX都不可以
        //如果对OP_WRITE感兴趣，选择器认为现在可以写，会把ReadOPS=4，是可读状态
        //如果是OP_READ，选择器认为现在什么也没发生，即不可读。
        //doc解释是，选择器认为这个channel可以发生IO操作了，才返回。这个可以发生IO操作的判断标准跟设置的感兴趣set有关的
        sc.register(selector, SelectionKey.OP_WRITE|SelectionKey.OP_READ);
        selector.select();
        Set<SelectionKey> keys1 = selector.selectedKeys();
        System.out.println();
    }
}
