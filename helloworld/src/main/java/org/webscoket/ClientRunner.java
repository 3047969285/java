package org.webscoket;

public class ClientRunner {
    public static void main(String[] args) {
        System.out.println("请选择要运行的客户端:");
        System.out.println("1. WebSocketClient (命令行客户端)");
        System.out.println("2. SystemMessageSender (系统消息发送器)");
        
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
            
            switch (choice) {
                case 1:
                    WebSocketClient.main(args);
                    break;
                case 2:
                    SystemMessageSender.main(args);
                    break;
                default:
                    System.out.println("无效选择");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}