package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class SocketServer {
    public static final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    public static void main(String[] args) {
        SocketServer socket = new SocketServer();
        try {
            socket.server(44444);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void server(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);     //1
        try {
            for (;;) {
                final Socket clientSocket = socket.accept();    //2
                System.out.println("Accepted connection from " + clientSocket);

                new Thread(new Runnable() {                        //3
                    @Override
                    public void run() {
                        try {
                            InputStream in = clientSocket.getInputStream();
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            logger.debug(br.readLine().toString());

                            br = new BufferedReader(new InputStreamReader( System.in )) ;
                            String line = br.readLine();
                            OutputStream out = clientSocket.getOutputStream();
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                            bw.write(line);                            //4
                            bw.flush();
                            clientSocket.close();                //5
                        } catch (IOException e) {
                            e.printStackTrace();
                            try {
                                clientSocket.close();
                            } catch (IOException ex) {
                                // ignore on close
                            }
                        }
                    }
                }).start();                                        //6
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

