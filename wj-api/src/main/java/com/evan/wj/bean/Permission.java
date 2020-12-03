package com.evan.wj.bean;

/**
 * @author lihonghao
 * @date 2020/12/3 21:30
 */
public class Permission {
	private String id;
	private String permissionsName;

	public Permission() {
	}

	public Permission(String id, String permissionsName) {
		this.id = id;
		this.permissionsName = permissionsName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionsName() {
		return permissionsName;
	}

	public void setPermissionsName(String permissionsName) {
		this.permissionsName = permissionsName;
	}
}
