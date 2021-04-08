package com.wk.netty.chats;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.*;

public class NettyClient {
    public static void main(String[] args) {
        //创建线程组 evtGroup
        EventLoopGroup evtGroup = new NioEventLoopGroup();
        try {
            //创建client的启动对象，设置参数
            Bootstrap bootstrap = new Bootstrap();
            //set threads group
            bootstrap.group(evtGroup)
                    //设置服务端通道实现类型
                    .channel(NioSocketChannel.class)
                    //使用匿名内部类的形式初始化通道对象
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //给pipeline管道设置处理器
                            socketChannel.pipeline()
                                         .addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()))
                                         .addLast(new StringEncoder())
                                         .addLast(new StringDecoder())
                                         .addLast(new ClientHandler());
                        }
                    });

            try {
                Channel channel = bootstrap.connect("127.0.0.1", 6666).sync().channel();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                for (;;) {
                    channel.writeAndFlush(br.readLine() + "\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            evtGroup.shutdownGracefully();
        }
    }
}
