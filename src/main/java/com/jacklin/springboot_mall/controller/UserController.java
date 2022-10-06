package com.jacklin.springboot_mall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacklin.springboot_mall.dto.UserRegisterRequest;
import com.jacklin.springboot_mall.model.User;
import com.jacklin.springboot_mall.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
		Integer userId = userService.register(userRegisterRequest);
		User user = userService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
}
