package com.montran.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montran.main.bean.UserDetailsRequest;
import com.montran.main.dbBean.UserDetails;
import com.montran.main.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
	
	
	@Autowired
	UserService userService; 
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public UserDetailsRequest addUser(@RequestBody UserDetailsRequest userDetails) {
		userService.saveOrUpdate(userDetails);
		System.out.println("requestBody "+userDetails);
		return userDetails;
	}
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
	public List<UserDetails> getAllUsers() {
		return userService.getAllUser();
	}
	
	@RequestMapping(value = "/fetch/{userId}", produces = "application/json")
	public UserDetails getUser(@PathVariable("userId") String id) {
		System.out.println("userId : "+id);
		return userService.getUser(id);
	}
	
	
}
