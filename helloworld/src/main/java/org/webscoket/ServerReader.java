package org.webscoket;

import org.glassfish.tyrus.server.Server;

import java.io.*;
import java.net.Socket;

public class ServerReader extends Thread{
          private Socket socket;
          public ServerReader(Socket socket){
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
                          System.out.println("服务端收到消息："+message);
                          sendMsgtoAll(message);
                      } catch (Exception e) {
                          System.out.println("有人下线了"+socket.getInetAddress());
                          Seervice2.Lines.remove(socket);
                          dis.close();
                          socket.close();
                          break;
                      }
                  }
              } catch (Exception e) {
                  System.out.println("服务器读取异常: " + e.getMessage());
              } finally {
                  try {
                      if (socket != null && !socket.isClosed()) {
                          socket.close();
                      }
                  } catch (IOException e) {
                      System.out.println("关闭socket时出错: " + e.getMessage());
                  }
                  System.out.println("客户端连接已完全关闭");
              }
    }

    private void sendMsgtoAll(String message) {
        for (Socket s : Seervice2.Lines) {
            try {
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(message);
            } catch (Exception e) {
                System.out.println("发送消息异常: " + e.getMessage());
            }
        }
    }

}