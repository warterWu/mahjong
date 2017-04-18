package com.mahjong.server.util;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 请求返回结果 </br>
 * 
 * @author wumiao
 * @param <T>
 */
public class WebResponse<T> {
	// 请求状态
	private int errcode = ResponseCode.STATUS_OK.getInfocode();

	// 请求数据
	private T data;

	// 错误码信息
	private String errmsg;

	public WebResponse(int errcode, T data, String errmsg) {
		this.errcode = errcode;
		this.data = data;
		this.errmsg = errmsg;
	}

	public void setResponse(ResponseCode code, T data) {
		this.data = data;
		this.errcode = code.getInfocode();
		this.errmsg = code.getDebugInfo();
	}

	public WebResponse() {
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
