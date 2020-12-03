package com.evan.wj.bean;

import java.util.Set;

/**
 * 用户类
 *
 * @author lihonghao
 * @date 2020/11/26 20:37
 */
public class User {
	private String id;
	private String userName;
	private String passWord;
	private String realName;

	/**
	 * 用户对应的角色集合
	 */
	private Set<Role> roles;

	public User() {
	}

	public User(String id, String userName, String passWord, String realName, Set<Role> roles) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.realName = realName;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
