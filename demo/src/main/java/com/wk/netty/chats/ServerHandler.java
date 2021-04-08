package com.wk.netty.chats;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends SimpleChannelInboundHandler<String> {
    private static DefaultChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channelGroup.size());
        channelGroup.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush("[" + ch.remoteAddress() + "] " + msg + "\n");
            } else {
                ch.writeAndFlush("[Myself] " + msg + "\n");
            }
        });
    }

    @Override
    public void channelActive(io.netty.channel.ChannelHandlerContext ctx) throws java.lang.Exception {
        System.out.println(ctx.channel().remoteAddress() + " connect");
    }

    @Override
    public void channelInactive(io.netty.channel.ChannelHandlerContext ctx) throws java.lang.Exception {
        System.out.println(ctx.channel().remoteAddress() + " disconnect");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception{
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[Server] " + channel.remoteAddress() + " is connected\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(io.netty.channel.ChannelHandlerContext ctx) throws java.lang.Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[Server] " + channel.remoteAddress() + " disconnected\n");
        channelGroup.remove(channel);
    }

    @Override
    public void exceptionCaught(io.netty.channel.ChannelHandlerContext ctx, java.lang.Throwable cause) throws java.lang.Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
