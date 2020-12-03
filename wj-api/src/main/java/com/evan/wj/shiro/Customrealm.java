package com.evan.wj.shiro;

import com.evan.wj.bean.Permission;
import com.evan.wj.bean.Role;
import com.evan.wj.bean.User;
import com.evan.wj.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * 自定义realm
 *
 * @author lihonghao
 * @date 2020/12/3 21:54
 */
public class Customrealm extends AuthorizingRealm {

	@Autowired private LoginService loginService;

	/**
	 * 权限配置
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 偶去登录名
		String name = (String) principalCollection.getPrimaryPrincipal();
		// 查询用户名称
		User user = loginService.getMapByName(name);
		// 添加角色权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (Role role : user.getRoles()) {
			// 添加角色
			simpleAuthorizationInfo.addRole(role.getRoleName());
			for (Permission permission : role.getPermission()) {
				simpleAuthorizationInfo.addStringPermission(permission.getPermissionsName());
			}
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		if (StringUtils.isEmpty(authenticationToken.getPrincipal())) {
			return null;
		}
		// 获取用户信息
		String name = authenticationToken.getPrincipal().toString();
		User user = loginService.getMapByName(name);
		if (user == null) {
			// 这里返回后会报出异常
			return null;
		} else {
			//这里验证authenticationToken和simpleAuthenticationInfo的信息
			SimpleAuthenticationInfo simpleAuthorizationInfo = new SimpleAuthenticationInfo();
			return simpleAuthorizationInfo;
		}
	}
}
