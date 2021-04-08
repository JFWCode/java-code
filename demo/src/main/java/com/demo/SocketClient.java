package com.demo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketClient {
    private static final Logger logger = LoggerFactory.getLogger(SocketClient.class);

    public static void main(String[] args) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            Socket s = new Socket("127.0.0.1",6666);

                            //构建IO
                            InputStream is = s.getInputStream();
                            OutputStream os = s.getOutputStream();

                            // get input from cmdline
                            BufferedReader brCmd = new BufferedReader(new InputStreamReader(System.in));
                            String line = brCmd.readLine();
                            logger.debug("Me: {}", line);

                            //向服务器端发送一条消息
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                            bw.write(line + "\n");
                            bw.flush();

                            //读取服务器返回的消息
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String mess = br.readLine();
                            logger.debug("Server: {}", mess);
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
    }
}
