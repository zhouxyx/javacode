package com.xxx.javacode.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {

	private final String host;
	private final int port;
	public EchoClient(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	public void start() throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
				.remoteAddress(host, port)
				.handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new EchoClientHandler());
					}
				});
			
			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
			
		} finally {
			// TODO: handle finally clause
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					new EchoClient("127.0.0.1", 8888).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		for (int i = 0; i < 200; i++) {
			Thread t = new Thread(r);
			t.start();
		}
	}
}
