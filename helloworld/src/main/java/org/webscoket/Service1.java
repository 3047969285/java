package org.webscoket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Service1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket id1 = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true){
             String message = sc.next();
             byte[] buf = message.getBytes();
            if ("exit".equals(message))
            {
               System.out.println("退出");
                id1.close();
                break;
            }
            DatagramPacket packet1 = new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(), 8888);
            id1.send(packet1);
            System.out.println("发送数据成功");

        }
    }
}
