package com.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResuUtil<T> {
	/** 成功 */
	public static final int SUCCESS = 200;

	/** 没有登录 */
	public static final int NOT_LOGIN = 400;

	/** 发生异常 */
	public static final int EXCEPTION = 401;

	/** 系统错误 */
	public static final int SYS_ERROR = 402;

	/** 参数错误 */
	public static final int PARAMS_ERROR = 403;

	/** 不支持或已经废弃 */
	public static final int NOT_SUPPORTED = 410;

	/** AuthCode错误 */
	public static final int INVALID_AUTHCODE = 444;

	/** 太频繁的调用 */
	public static final int TOO_FREQUENT = 445;

	/** 未知的错误 */
	public static final int UNKNOWN_ERROR = 499;
	
	private int code;
	private String msg;
	private T data;
	
	

	public static JsonResuUtil build() {
		return new JsonResuUtil();
	}
	public static JsonResuUtil build(int code) {
		return new JsonResuUtil().code(code);
	}
	public static JsonResuUtil build(int code, String msg) {
		return new JsonResuUtil<String>().code(code).msg(msg);
	}
	public static <T> JsonResuUtil<T> build(int code, T data) {
		return new JsonResuUtil<T>().code(code).data(data);
	}
	public static <T> JsonResuUtil<T> build(int code, String msg, T data) {
		return new JsonResuUtil<T>().code(code).msg(msg).data(data);
	}
	
	public JsonResuUtil<T> code(int code) {
		this.code = code;
		return this;
	}
	public JsonResuUtil<T> msg(String msg) {
		this.msg = msg;
		return this;
	}
	public JsonResuUtil<T> data(T data) {
		this.data = data;
		return this;
	}
	
	
	public static JsonResuUtil ok() {
		return build(SUCCESS);
	}
	public static JsonResuUtil ok(String msg) {
		return build(SUCCESS, msg);
	}
	public static <T> JsonResuUtil<T> ok(T data) {
		return build(SUCCESS, data);
	}
	public static JsonResuUtil err() {
		return build(EXCEPTION);
	}
	public static JsonResuUtil err(String msg) {
		return build(EXCEPTION, msg);
	}
	
	@Override
	public String toString() {
		return JsonUtil.to(this);
	}
}
