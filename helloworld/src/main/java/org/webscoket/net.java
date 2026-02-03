package org.webscoket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;
import static java.net.InetAddress.getLocalHost;

public class net {
    public static void main(String[] args) throws IOException {
        InetAddress id1= null;
        try {
            id1 = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id1);
        System.out.println(id1.getHostName());
        System.out.println(id1.getHostAddress());
        InetAddress id2 = null;
        try {
            id2 = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id2);
        System.out.println(id2.getHostName());
        System.out.println(id2.getHostAddress());
        System.out.println(id2.isReachable(5000));
    }
}
