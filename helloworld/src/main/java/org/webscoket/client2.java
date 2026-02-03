package org.webscoket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

public class client2 {



    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);

        new ClientReader(socket).start();
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner( System.in);
        while(true)
        {

            String message = sc.next();
            dos.writeUTF(message);
            if(message.equals("bye"))
            {
                dos.close();
                socket.close();
            }
        }
    }
}
