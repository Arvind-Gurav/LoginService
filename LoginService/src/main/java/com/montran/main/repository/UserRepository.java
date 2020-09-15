package com.montran.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montran.main.dbBean.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long>{
	
	List<UserDetails> findByUserName(String userName);
}
