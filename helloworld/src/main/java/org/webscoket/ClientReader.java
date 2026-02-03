package org.webscoket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientReader extends Thread{
    private Socket socket;

    public ClientReader(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            while(true){
                try{
                    String message = dis.readUTF();
                    System.out.println("客户端收到消息："+message);
                } catch (Exception e) {
                    System.out.println("有人下线了"+socket.getInetAddress());
                    dis.close();
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("服务器读取异常: " + e.getMessage());
        }
    }
}
