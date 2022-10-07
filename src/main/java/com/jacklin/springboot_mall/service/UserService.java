package com.jacklin.springboot_mall.service;

import com.jacklin.springboot_mall.dto.UserLoginRequest;
import com.jacklin.springboot_mall.dto.UserRegisterRequest;
import com.jacklin.springboot_mall.model.User;

public interface UserService {
	
	User getUserById(Integer userId);
	
	Integer register(UserRegisterRequest userRegisterRequest);
	
	User login(UserLoginRequest userLoginRequest);
}
