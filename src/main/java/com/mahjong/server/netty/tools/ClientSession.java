package com.mahjong.server.netty.tools;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.ChannelHandlerContext;

public class ClientSession {
	public static Map<String, ChannelHandlerContext> sessionMap = new HashMap<String, ChannelHandlerContext>();

}
