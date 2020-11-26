package com.evan.wj.pojo;

/**
 * 用户类
 *
 * @author lihonghao
 * @date 2020/11/26 20:37
 */
public class User {
	private Integer id;
	private String userName;
	private String passWord;
	private String realName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
