package com.evan.wj.service;

import com.evan.wj.bean.User;

/**
 * @author lihonghao
 * @date 2020/12/3 21:36
 */
public interface UserService {
	/**
	 * 通过id获取用户
	 *
	 * @param id
	 * @return
	 */
	User getUserById(int id);

	/**
	 * 通过用户名获取用户
	 *
	 * @param name
	 * @return
	 */
	User getUserByName(String name);
}
