package com.mahjong.server.netty.codec;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mahjong.server.netty.model.ProtocolModel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

@Component
@ChannelHandler.Sharable
public class WebSocketProtocolCodec extends MessageToMessageCodec<TextWebSocketFrame, ProtocolModel> {


	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, ProtocolModel protocolModel, List<Object> out)
			throws Exception {
		out.add(new TextWebSocketFrame(JSON.toJSONString(protocolModel)));
	}

	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame,
			List<Object> in) throws Exception {
		String text = textWebSocketFrame.text();
		List<ProtocolModel> result = JSON.parseObject(text, new TypeReference<List<ProtocolModel>>() {
		});
		if (CollectionUtils.isNotEmpty(result)) {
			for (ProtocolModel protocolModel : result) {
				in.add(protocolModel);
			}
		}
		
	}
}
