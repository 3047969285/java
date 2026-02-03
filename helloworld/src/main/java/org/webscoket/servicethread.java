package org.webscoket;

import java.io.*;
import java.net.Socket;

public class servicethread extends Thread {
    private Socket socket;

    public servicethread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream os = socket.getOutputStream();
             PrintStream ps = new PrintStream(os)) {
            
            // 发送HTTP响应头
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/html; charset=utf-8");
            ps.println("Connection: close");
            ps.println();
            
            // 发送HTML内容
            ps.println("<!DOCTYPE html>");
            ps.println("<html>");
            ps.println("<head><title>服务器响应</title></head>");
            ps.println("<body>");
            ps.println("<div style='color:red;font-size:100px;text-align:center'>方形</div>");
            ps.println("</body>");
            ps.println("</html>");
            
        } catch (Exception e) {
            System.err.println("处理客户端请求时发生异常: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                System.err.println("关闭socket时发生异常: " + e.getMessage());
            }
        }
    }
}