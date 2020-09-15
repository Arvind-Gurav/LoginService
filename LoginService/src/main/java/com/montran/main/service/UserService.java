package com.montran.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montran.main.bean.UserDetailsRequest;
import com.montran.main.dbBean.UserDetails;
import com.montran.main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public boolean saveOrUpdate(UserDetailsRequest userDetails) {
		try {
			UserDetails user = null;
			List<UserDetails> userList = userRepository.findByUserName(userDetails.getUserName());
			if(userList.isEmpty()) {
				user = new UserDetails();
			} else {
				user = userList.get(0);
			}
			user.setUserName(userDetails.getUserName());
			user.setPassword(userDetails.getPassword());
			
			userRepository.save(user);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<UserDetails> getAllUser() {
		try {
			return userRepository.findAll();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UserDetails getUser(String id) {
		try {
			Optional<UserDetails> det = userRepository.findById(Long.parseLong(id));
			return det.get();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
