package com.mahjong.server.netty.handler;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mahjong.server.netty.model.AuthModel;
import com.mahjong.server.netty.model.EventEnum;
import com.mahjong.server.netty.model.ProtocolModel;
import com.mahjong.server.netty.tools.ClientSession;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 登陆认证
 *
 */
@Component
public class AuthHandler extends SimpleChannelInboundHandler<ProtocolModel> {


	@Override
	public void channelRead0(ChannelHandlerContext ctx, ProtocolModel protocolModel) throws Exception {
		if (protocolModel.getCommandId() == EventEnum.AUTH_REQ.getValue()) {
			if (protocolModel.getBody() == null) {
				ctx.close();
			} else {
				AuthModel authModel = JSON.parseObject(new String(protocolModel.getBody(), "UTF-8"),
						new TypeReference<AuthModel>() {
						});

				String key = authModel.getShellId() + "";
				// authEventService.setAuthToken(ctx.channel(), authModel);

				ClientSession.sessionMap.put(key, ctx);

				// 回写ACK
				protocolModel.setCommandId(EventEnum.AUTH_RESP.getValue());
				ctx.writeAndFlush(protocolModel);
			}
		} else {
			ctx.fireChannelRead(protocolModel);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.fireExceptionCaught(cause);
	}
}