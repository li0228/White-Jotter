package com.evan.wj.service;

import com.evan.wj.bean.User;

/**
 * @author lihonghao
 * @date 2020/12/3 21:37
 */
public interface LoginService {
	User getMapByName(String name);
}
