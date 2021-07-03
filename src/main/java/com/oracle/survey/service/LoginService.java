package com.oracle.survey.service;

import com.oracle.survey.dto.LoginDTO;

public interface LoginService {
	
	LoginDTO verifyUser(LoginDTO loginDTO);

}
