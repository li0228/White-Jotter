package com.evan.wj.controller;

import com.evan.wj.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihonghao
 * @date 2020/11/26 20:48
 */
@Controller public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login") public String login(User user) {
		logger.error("用户名不存在！");
		if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassWord())) {
			return "请输入用户名和密码！";
		}
		//用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
		try {
			//进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
			//            subject.checkRole("admin");
			//            subject.checkPermissions("query", "add");
		} catch (UnknownAccountException e) {
			logger.error("用户名不存在！", e);
			return "用户名不存在！";
		} catch (AuthenticationException e) {
			logger.error("账号或密码错误！", e);
			return "账号或密码错误！";
		} catch (AuthorizationException e) {
			logger.error("没有权限！", e);
			return "没有权限";
		}
		return "login success";
	}

	@RequiresRoles("admin") @RequestMapping("/admin") public String admin() {
		return "admin success!";
	}

	@RequiresPermissions("query") @RequestMapping("/index") public String index() {
		return "index success!";
	}

	@RequiresPermissions("add") @RequestMapping("/add") public String add() {
		return "add success!";
	}
}
