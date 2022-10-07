package com.jacklin.springboot_mall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.jacklin.springboot_mall.dao.UserDao;
import com.jacklin.springboot_mall.dto.UserLoginRequest;
import com.jacklin.springboot_mall.dto.UserRegisterRequest;
import com.jacklin.springboot_mall.model.User;
import com.jacklin.springboot_mall.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
		if (user != null) {
			log.warn("該email {} 已經被註冊",userRegisterRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			
		}
		
		return userDao.createUser(userRegisterRequest);
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}

	@Override
	public User login(UserLoginRequest userLoginRequest) {
		User user = userDao.getUserByEmail(userLoginRequest.getEmail());
		if (user == null) {
			log.warn("該email{}尚未註冊",userLoginRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		if (user.getPassword().equals(userLoginRequest.getPassword())) {
			return user;
			
		}else {
			log.warn("email {} 的密碼不正確",userLoginRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
