package com.mahjong.server.netty.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mahjong.server.constant.Constants;
import com.mahjong.server.netty.channel.WebSocketChannelInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class WebSocketServer {

	private Logger logger = LoggerFactory.getLogger(WebSocketChannelInitializer.class);

	@Autowired
	private WebSocketChannelInitializer webSocketChannelInitializer;

	private final EventLoopGroup bossGroup = new NioEventLoopGroup();
	private final EventLoopGroup workGroup = new NioEventLoopGroup();
	private ChannelFuture channelFuture;

	/**
	 * 开启
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		try {
			logger.info("starting tcp server ... Port: " + Constants.WEBSOCKET_PORT);

			// 创建ServerBootstrap对象，它是Netty用于启动NIO服务端的辅助启动类， 目的是降低服务端的开发复杂度
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workGroup);
			bootstrap.channel(NioServerSocketChannel.class);
			// 处理业务
			bootstrap.handler(new LoggingHandler(LogLevel.INFO));
			// 绑定I/O事件的处理类
			bootstrap.childHandler(webSocketChannelInitializer);
			// 绑定端口，同步等待成功
			bootstrap.bind(Constants.WEBSOCKET_PORT).sync();
		} finally {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					shutdown();
				}
			});
		}
	}

	/**
	 * 重启
	 * 
	 * @throws Exception
	 */
	public void restart() throws Exception {
		shutdown();
		start();
	}

	/**
	 * 关闭
	 */
	public void shutdown() {
		if (channelFuture != null) {
			channelFuture.channel().close().syncUninterruptibly();
		}
		if (bossGroup != null) {
			bossGroup.shutdownGracefully();
		}
		if (workGroup != null) {
			workGroup.shutdownGracefully();
		}
	}
}