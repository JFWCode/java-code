package com.demo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class SocketClient {
    public static void main(String[] args) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket s = new Socket("127.0.0.1",44444);

                        //构建IO
                        InputStream is = s.getInputStream();
                        OutputStream os = s.getOutputStream();

                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                        //向服务器端发送一条消息
                        bw.write("Hi server\n");
                        bw.flush();

                        //读取服务器返回的消息
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String mess = br.readLine();
                        System.out.println("Server:"+mess);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
