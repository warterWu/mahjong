package com.mahjong.server.handler;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.mahjong.server.util.ResponseCode;
import com.mahjong.server.util.WebResponse;
 
public class ApiJsonHandlerExceptionResolver extends DefaultHandlerExceptionResolver {
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		response.setContentType("application/json;charset=utf-8");
		WebResponse<String> webResponse = new WebResponse<String>();
		logger.warn("interface exception", ex);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			if (ex instanceof NoSuchRequestHandlingMethodException) {
				try {
					webResponse.setResponse(ResponseCode.NO_FUNCTION_MAPPED_TO_HANDLE, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 404, NoSuchRequestHandlingMethod", e);
				}
				return new ModelAndView();
			} else if (ex instanceof HttpRequestMethodNotSupportedException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 405, HttpRequestMethodNotSupported", e);
				}
				return new ModelAndView();
			} else if (ex instanceof HttpMediaTypeNotSupportedException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 415, HttpMediaTypeNotSupported", e);
				}
				return new ModelAndView();
			} else if (ex instanceof HttpMediaTypeNotAcceptableException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 406, HttpMediaTypeNotSupported", e);
				}
				return new ModelAndView();
			} else if (ex instanceof MissingServletRequestParameterException) {
				/**
				 * 如果参数缺失，需要返回Error告诉客户端
				 */
				try {
					webResponse.setResponse(ResponseCode.MISSING_REQUIRED_PARAMS, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 400, MissingServletRequestParameter", e);
				}

				return new ModelAndView();
			} else if (ex instanceof ServletRequestBindingException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 406, HttpMediaTypeNotSupported", e);
				}
				return new ModelAndView();
			} else if (ex instanceof ConversionNotSupportedException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 500, ConversionNotSupported", e);
				}
				return new ModelAndView();
			} else if (ex instanceof TypeMismatchException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 400, TypeMismatch", e);
				}
				return new ModelAndView();
			} else if (ex instanceof HttpMessageNotReadableException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 400, HttpMessageNotReadable", e);
				}
				return new ModelAndView();
			} else if (ex instanceof HttpMessageNotWritableException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 500, HttpMessageNotWritable", e);
				}
				return new ModelAndView();
			} else if (ex instanceof MethodArgumentNotValidException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 400, MethodArgumentNotValidException", e);
				}
				return new ModelAndView();
			} else if (ex instanceof MissingServletRequestPartException) {
				try {
					webResponse.setResponse(ResponseCode.ILLEGAL_REQUEST, null);
					writer.write((JSON.toJSONString(webResponse)));
					writer.flush();
					writer.close();
				} catch (Exception e) {
					logger.warn("httpcode : 400, MissingServletRequestPartException", e);
				}
				return new ModelAndView();
			}
		} catch (Exception handlerException) {
			logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
			try {
				webResponse.setResponse(ResponseCode.FALIED_OF_INNER_SERVICE, null);
				writer.write((JSON.toJSONString(webResponse)));
				writer.flush();
				writer.close();
			} catch (Exception e) {
				logger.warn("httpcode : 400, Exception", e);
			}
			return new ModelAndView();
		} finally {
			logger.warn("", ex);
		}

		try {
			webResponse.setResponse(ResponseCode.FALIED_OF_INNER_SERVICE, null);
			writer.write((JSON.toJSONString(webResponse)));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.warn("httpcode : 400, MissingServletRequestPartException", e);
		}
		return new ModelAndView();
	}
}
