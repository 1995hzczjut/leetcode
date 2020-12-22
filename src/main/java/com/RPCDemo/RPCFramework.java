package com.RPCDemo;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 对象流使用，这个DEMO印证了文档说的
 * 只要有 Protocol + Invoker + Exporter 就可以完成非透明的 RPC 调用
 *
 * @author Zhancong Huang
 * @date 10:28 2019/7/7
 */
public class RPCFramework {

    /**
     * 最简单的服务暴露，反射（找到某个方法，并执行），动态代理
     */
    @SuppressWarnings("unchecked")
    public static <T> void export(Class<T> implClass, int port) {
        checkNull(implClass);
        checkPort(port);
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                //方法名，参数类型数组，参数值。传这些东西取决于下面两个反射的API
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] args = (Object[]) input.readObject();
                //找到方法并执行
                Method method = implClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(implClass.newInstance(), args);

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用时只知道对方地址，和哪个接口。
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(Class<T> interfaceClass, String host, int port) {
        checkNull(interfaceClass, host);
        checkPort(port);
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            Socket socket = new Socket(host, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeUTF(method.getName());
            out.writeObject(method.getParameterTypes());
            out.writeObject(args);
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Object result = input.readObject();
            if (result instanceof Throwable) {
                throw (Throwable) result;
            }
            socket.close();
            return result;
        };
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, invocationHandler);
    }


    private static void checkPort(int port) {
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNull(Object... o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
    }


}
