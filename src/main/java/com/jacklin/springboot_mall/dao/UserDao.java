package com.jacklin.springboot_mall.dao;

import com.jacklin.springboot_mall.dto.UserRegisterRequest;
import com.jacklin.springboot_mall.model.User;

public interface UserDao {
	User getUserById(Integer userId);
	
	Integer createUser(UserRegisterRequest userRegisterRequest);

}
