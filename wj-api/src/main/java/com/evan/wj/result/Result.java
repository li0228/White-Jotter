package com.evan.wj.result;

/**
 * @author lihonghao
 * @date 2020/11/26 20:40
 */
public class Result {
	//响应码
	private int code;

	//响应信息
	private String message;

	public Result() {
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
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
}
