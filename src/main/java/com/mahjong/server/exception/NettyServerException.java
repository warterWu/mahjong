package com.mahjong.server.exception;

public class NettyServerException extends Exception {

	public NettyServerException(String message) {
		super(message);
	}

	public NettyServerException(String message, Throwable cause) {
		super(message, cause);
	}

}
