package com.evan.wj.bean;

import java.util.Set;

/**
 * @author lihonghao
 * @date 2020/12/3 21:28
 */
public class Role {
	private String id;
	private String roleName;

	/**
	 * 角色对应的权限集合
	 */
	private Set<Permission> permission;

	public Role() {
	}

	public Role(String id, String roleName, Set<Permission> permission) {
		this.id = id;
		this.roleName = roleName;
		this.permission = permission;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
}
