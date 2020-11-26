package com.evan.wj.service;

import com.evan.wj.mapper.UserMapper;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihonghao
 * @date 2020/11/26 22:21
 */

@Service public class UserService {
	@Autowired UserMapper userMapper;

	public User Sel(int id) {
		return userMapper.Sel(id);
	}
}