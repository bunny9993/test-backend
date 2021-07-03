package com.oracle.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.survey.dao.LoginDAO;
import com.oracle.survey.dto.LoginDTO;
import com.oracle.survey.entity.UserMST;
import com.oracle.survey.service.LoginService;

@Transactional
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public LoginDTO verifyUser(LoginDTO loginDTO) {
		
		UserMST userMst=loginDAO.checkUser(loginDTO);
		
		LoginDTO loginResponse = new LoginDTO();
		if(userMst!=null) {
			loginResponse.setUserId(userMst.getUserId());
			loginResponse.setUserEmail(userMst.getUserEmail());
			loginResponse.setUserType(userMst.getUserType());
			loginResponse.setIsActive(userMst.getActiveFlag());
		}
		
		return loginResponse;
	}
	

}
