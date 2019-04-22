package com.project.world.lean.netty.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) {
        ServerSocket server = null;
        ServerThread thread;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(4331);
            } catch (IOException e1) {
                System.out.println("正在监听");
            }
            try {
                System.out.println("等待客户呼叫");
                you = server.accept();
                System.out.println("客户的地址：" + you.getInetAddress());

            } catch (IOException e) {
                System.out.println("正在等待客户");
            }
            if (you != null) {
                new ServerThread(you).start();
            }
        }
    }
}

class ServerThread extends Thread {
    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    String s;

    ServerThread(Socket t) {
        socket = t;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

        } catch (IOException e) {
        }

    }

    public void run() {
        while (true) {
            try {
                double s1 = in.readDouble();
                double s2 = in.readDouble();
                double area = s1 * s2;
                out.writeUTF("长" + s1 + "宽" + s2 + "的长方体的面积" + area);

            } catch (IOException e) {
                System.out.println("客户离开");
                return;
            }
        }
    }
}

