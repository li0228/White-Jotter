package com.evan.wj.service.Impl;

import com.evan.wj.bean.Permission;
import com.evan.wj.bean.Role;
import com.evan.wj.bean.User;
import com.evan.wj.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

/**
 * @author lihonghao
 * @date 2020/12/3 21:38
 */
@Service public class LoginServiceImpl implements LoginService {
	@Override public User getMapByName(String name) {
		Permission permission1 = new Permission("1", "query");
		Permission permission2 = new Permission("2", "add");
		Set<Permission> permissions = new HashSet<>();
		permissions.add(permission1);
		permissions.add(permission2);
		Role role = new Role("1", "admin", permissions);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		User user = new User("1", "wsl", "管理员", "123456", roles);

		Map<String, User> map = new HashMap<>();
		map.put(user.getUserName(), user);

		Set<Permission> permissionsSet1 = new HashSet<>();
		permissionsSet1.add(permission1);
		Role role1 = new Role("2", "user", permissionsSet1);
		Set<Role> roleSet1 = new HashSet<>();
		roleSet1.add(role1);
		User user1 = new User("2", "zhangsan", "普通用户", "123456", roleSet1);
		map.put(user1.getUserName(), user1);

		return map.get(name);
	}
}
