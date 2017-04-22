package com.mahjong.server.exception;

public class NotChannelException extends NettyServerException {

	public NotChannelException() {
		super("channelHandlerContext not found");
	}

}
