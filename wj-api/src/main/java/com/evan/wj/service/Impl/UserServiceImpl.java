package com.evan.wj.service.Impl;

import com.evan.wj.dao.UserMapper;
import com.evan.wj.bean.User;
import com.evan.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihonghao
 * @date 2020/11/26 22:21
 */

@Service public class UserServiceImpl implements UserService {

	@Autowired UserMapper userMapper;

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getUserByName(String name) {
		return userMapper.selectByName(name);
	}
}