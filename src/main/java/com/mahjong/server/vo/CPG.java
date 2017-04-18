package com.mahjong.server.vo;

public enum CPG {
	NONE(0, "毛都没有"), CHI(1, "吃"), PENG(2, "碰"), PENG_GANG(3, "碰/杠");
	private int code;
	private String msg;

	CPG(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
