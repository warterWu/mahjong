package com.mahjong.server.netty.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mahjong.server.netty.codec.WebSocketProtocolCodec;
import com.mahjong.server.netty.handler.AuthHandler;
import com.mahjong.server.netty.handler.MahjongLogicHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

@Component
public class WebSocketChannelInitializer extends ChannelInitializer<NioSocketChannel> {

	@Autowired
	private WebSocketProtocolCodec webSocketProtocolCodec;
	@Autowired
	private AuthHandler authHandler;
	@Autowired
	private MahjongLogicHandler mahjongLogicHandler;
	protected void initChannel(NioSocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		// 编解码 http请求
		pipeline.addLast(new HttpServerCodec());
		// 写文件内容
		pipeline.addLast(new ChunkedWriteHandler());
		// 聚合解码 HttpRequest/HttpContent/LastHttpContent到FullHttpRequest
		// 保证接收的 Http请求的完整性
		pipeline.addLast(new HttpObjectAggregator(64 * 1024));
		// 处理其他的 WebSocketFrame
		pipeline.addLast(new WebSocketServerProtocolHandler("/mj"));
		// 处理 TextWebSocketFrame
		pipeline.addLast(webSocketProtocolCodec);
		pipeline.addLast(authHandler);
		pipeline.addLast(mahjongLogicHandler);
	}
}
