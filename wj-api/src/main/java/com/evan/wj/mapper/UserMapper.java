package com.evan.wj.mapper;

import com.evan.wj.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository public interface UserMapper {

	User getUserById(int id);
}