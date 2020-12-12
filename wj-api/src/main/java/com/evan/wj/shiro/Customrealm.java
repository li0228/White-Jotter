package com.evan.wj.shiro;

import com.evan.wj.bean.User;
import com.evan.wj.service.LoginService;
import com.evan.wj.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
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
	@Autowired private UserService userService;

	/**
	 * 权限配置
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
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
		String username = (String) authenticationToken.getPrincipal();                //得到用户名
		String password = new String((char[]) authenticationToken.getCredentials());    //得到密码

		// 判断是否有这个用户
		User user = userService.getUserByName(username);
		if (user == null) {
			throw new UnknownAccountException();//没有找到账号异常
		}
		String passWord = user.getPassWord();
		/**AuthenticatingRealm使用CredentialsMatcher进行密码匹配**/
		if (null != username && null != password) {
			return new SimpleAuthenticationInfo(username, password, getName());
		} else {
			return null;
		}

	}
}
