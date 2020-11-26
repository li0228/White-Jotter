package com.evan.wj.result;

/**
 * @author lihonghao
 * @date 2020/11/26 20:40
 */
public class Result {
	//响应码
	private int code;

	public Result(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
