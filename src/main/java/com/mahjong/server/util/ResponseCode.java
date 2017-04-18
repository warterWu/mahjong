package com.mahjong.server.util;

/**
 * 请求响应的业务状态码常量
 * 
 * @author wumiao
 *
 */
public enum ResponseCode {
	/**
	 * 请求成功
	 */
	STATUS_OK(0, "OK", "请求成功"), // 正常状态码
	/**
	 * 请求失败
	 */
	STATUS_ERROR(1, "ERROR", "请求失败"), // 非正常状态码
	/**
	 * 没有找到匹配的处理函数处理
	 */
	NO_FUNCTION_MAPPED_TO_HANDLE(10002, "NO_FUNCTION_MAPPED_TO_HANDLE", "没有找到匹配的处理函数处理"),
	 /**
     * 请求协议非法
     */
	ILLEGAL_REQUEST(10003, "ILLEGAL_REQUEST", "请求协议非法"),
    /**
     * 未知错误
     */
	UNKNOWN_ERROR(10004, "UNKNOWN_ERROR", "未知错误"),
	/**
	 * 缺少必填参数
	 */
	MISSING_REQUIRED_PARAMS(10005, "MISSING_REQUIRED_PARAMS", "缺少必填参数"),
	FALIED_OF_INNER_SERVICE(10015, "REGISTER_FALIED_OF_INNER_SERVICE", "内部服务执行遇到异常");

	private int infocode; // 响应编码
	private String info; // 对应说明（英文）
	private String debugInfo; // 响应说明（中文）

	/**
	 * @param infocode
	 * @param info
	 * @param debugInfo
	 */
	private ResponseCode(int infocode, String info, String debugInfo) {
		this.setInfocode(infocode);
		this.setInfo(info);
		this.setDebugInfo(debugInfo);
	}

	public int intInfocode() {
		return Integer.valueOf(infocode);
	}

	public int getInfocode() {
		return infocode;
	}

	public void setInfocode(int infocode) {
		this.infocode = infocode;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDebugInfo() {
		return debugInfo;
	}

	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}

	public static ResponseCode getResponseCodeByCode(int infocode) {
		for (ResponseCode responseCode : ResponseCode.values()) {
			if (responseCode.getInfocode() == infocode) {
				return responseCode;
			}
		}
		return null;
	}
}
