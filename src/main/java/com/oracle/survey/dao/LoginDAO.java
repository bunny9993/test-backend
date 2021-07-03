package com.oracle.survey.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.survey.dto.LoginDTO;
import com.oracle.survey.entity.UserMST;
import com.oracle.survey.repository.UserMstRepository;

@Repository
@Transactional
@ComponentScan("com.oracle.survey.dao")
public class LoginDAO {

	@Autowired
	private UserMstRepository userMstRepository;

	public UserMST checkUser(LoginDTO loginDto) {
		UserMST userMST = userMstRepository.checkUser(loginDto.getUserEmail(), loginDto.getUserPassword());
		return userMST;
	}
}
