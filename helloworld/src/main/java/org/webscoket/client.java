package org.webscoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class client {
    public static void main(String[] args) throws IOException {
        DatagramSocket id = new DatagramSocket(8888);
        System.out.println("启动客户端");
        while (true){
            byte[] buf = new byte[1024 *64];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            id.receive(packet);
            int length = packet.getLength();
            String message = new String(buf,0,length);
            System.out.println("收到服务端消息："+message);
        }

    }
}
