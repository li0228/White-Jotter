package com.evan.wj.controller;

import com.evan.wj.bean.User;
import com.evan.wj.result.Result;
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
@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login")
	@ResponseBody
	public Result login(User user) {
		if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassWord())) {
			//			return new Result(400,"请输入用户名或者密码");
			//			return "请输入用户名或者密码";
		}
		//用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassWord());
		try {
			//进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
		} catch (UnknownAccountException e) {
			logger.error("用户名不存在！", e);
			//			return new Result(400,"用户名不存在");
		} catch (AuthenticationException e) {
			logger.error("账号或密码错误！", e);
			//			return new Result(400,"账号或密码错误");
		} catch (AuthorizationException e) {
			logger.error("没有权限！", e);
			//			return new Result(400,"没有权限");
		}
		return new Result(200, "登录成功");
		//		return "登录成功";
	}

	@RequiresRoles("admin")
	@RequestMapping("/admin")
	public String admin() {
		return "admin success!";
	}

	@RequiresPermissions("query")
	@RequestMapping("/index")
	public String index() {
		return "index success!";
	}

	@RequiresPermissions("add")
	@RequestMapping("/add")
	public String add() {
		return "add success!";
	}
}
