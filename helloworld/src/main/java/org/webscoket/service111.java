package org.webscoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class service111 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("服务端启动，监听端口8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("有新的连接");
                new servicethread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("服务器发生异常: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("关闭服务器套接字时发生异常: " + e.getMessage());
                }
            }
        }
    }
}