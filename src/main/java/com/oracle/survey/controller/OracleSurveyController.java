package com.oracle.survey.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oracle.survey.dto.ResultMapper;
import com.oracle.survey.constants.MessageConstant;
import com.oracle.survey.dto.LoginDTO;
import com.oracle.survey.service.LoginService;

@RestController
@ComponentScan({"com.oracle.survey.service","com.oracle.survey.dao"})
@EnableJpaRepositories("com.oracle.survey.repository")
@EntityScan("com.oracle.survey.entity")
@RequestMapping(value = "/survey-management")
public class OracleSurveyController {
	
	private static final Logger logger = LoggerFactory.getLogger(OracleSurveyController.class);
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value = "/surveymanagementTest")
	public String hello() {
		return "{\"startmsg\":\" oracle survey management...up and running\"}";
	}
	
	@PostMapping(value = "/login")
	public ResultMapper login(@RequestBody LoginDTO loginDTO) {
		ResultMapper resultMapper = new ResultMapper();
		
		try {
			
			LoginDTO loginResponse=loginService.verifyUser(loginDTO);
			resultMapper.setResultObject(loginResponse);
			resultMapper.setMessage(MessageConstant.OK);
			resultMapper.setErrorCode(MessageConstant.SUCCESS_STATUS);
			
		} catch (Exception e) {
			return catchException(e);
		}
		return resultMapper;
	
	
	
	}
	private ResultMapper catchException(Exception e) {
		logger.error(e.getMessage());
		StackTraceElement[] st = e.getStackTrace();
		StringBuilder stackTraceMsg = new StringBuilder(e.getCause() + "\n" + e.getMessage() + "\n");
		for (StackTraceElement s : st) {
			stackTraceMsg.append(s + "\n");
		}
		logger.error(stackTraceMsg.toString());
		ResultMapper resultMapper = new ResultMapper();
		resultMapper.setResultObject(null);
		resultMapper.setMessage(MessageConstant.KO);
		resultMapper.setErrorCode(MessageConstant.ERROR_STATUS);
		return resultMapper;
	}
}

