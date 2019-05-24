package com.yaa.tio.tioim.web.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回 Json 字符串 VO
 */
public class ResponseVo {

	public static final int CODE_SUCCESS = 200;
	public static final int CODE_FAIL = 400;

	/**
	 * 返回状态码
	 */
	private int code;
	/**
	 * 返回错误信息
	 */
	private String message;
	/**
	 * 返回数据
	 */
	private Map<String,Object> item;

	public ResponseVo() {}

	public ResponseVo(int code, String message, Map<String,Object> item) {
		this.code = code;
		this.message = message;
		this.item = item;
	}

	public static ResponseVo instance(int code, String message) {
		return new ResponseVo(code, message);
	}

	public ResponseVo(int code, String message) {
		this.code = code;
		this.message = message;
	}


	public void addItem(String key,Object value){
		if(this.item == null){
			this.item = new HashMap<>();
		}
		this.item.put(key,value);
	}

	public static ResponseVo success() {
		return new ResponseVo(CODE_SUCCESS, "SUCCESS", null);
	}

	public static ResponseVo success(String msg) {
		return new ResponseVo(CODE_SUCCESS, msg, null);
	}

	public static ResponseVo fail(String msg) {
		return new ResponseVo(CODE_FAIL, msg, null);
	}

	public static ResponseVo fail() {
		return new ResponseVo(CODE_FAIL, "FAIL", null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getItem() {
		return item;
	}

	public void setItem(Map<String, Object> item) {
		this.item = item;
	}
}
