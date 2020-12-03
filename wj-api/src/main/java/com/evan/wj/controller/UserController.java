package com.evan.wj.controller;

import com.evan.wj.bean.User;
import com.evan.wj.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihonghao
 * @date 2020/11/26 22:20
 */

@RestController @RequestMapping("/testBoot") public class UserController {
	@Autowired private UserServiceImpl userService;

	/**
	 * 根据id获取用户
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("getUser/{id}") public User GetUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
}
