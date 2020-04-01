package com.luban.server;

import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {

    /*private int port = 8080;
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public  MyTomcat(){

    }

    public MyTomcat(int port){
        this.port = port;
    }

    public void start() throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("my tomcat start on "+port);
        while(true){
            Socket socket =  serverSocket.accept();
            socket.getOutputStream().write("hello world".getBytes());
            socket.close();
        }
    }*/

    public static void main(String[] args) {
        // MyTomcat tomcat = new MyTomcat();
        // tomcat.start();
        int a = 9;
        int b =10;
        System.out.println(a+b+b+b+b+b);
    }
}
