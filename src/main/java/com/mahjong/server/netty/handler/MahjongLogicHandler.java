package com.mahjong.server.netty.handler;

import org.springframework.stereotype.Component;

import com.mahjong.server.netty.model.ProtocolModel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@Component
public class MahjongLogicHandler extends SimpleChannelInboundHandler<ProtocolModel> {

	@Override
	protected void channelRead0(ChannelHandlerContext paramChannelHandlerContext, ProtocolModel paramI)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
