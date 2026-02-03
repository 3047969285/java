package org.webscoket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Seervice2 {
    public static List<Socket>Lines = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocket  oo = new ServerSocket(8080);
        System.out.println("服务器启动，监听端口 8080");
        while (true){
            Socket socket = oo.accept();
            Lines.add(socket);
            System.out.println("有人上线了"+socket.getInetAddress());
            new ServerReader(socket).start();
        }

    }
}