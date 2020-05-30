package com.modestack.Assignment.controller;

import org.hibernate.JDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.Assignment.entity.Login;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;
import com.modestack.Assignment.service.LoginService;

@RestController
@RequestMapping("/login")
public class UserLoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String userLogin(@RequestBody Login login) {
		LOGGER.info("Inside the method of userLogin()");
		
		try {
			String msg = loginService.userLogin(login);
			LOGGER.info("Exit from the method of userLogin()");
			return msg;
		}
		catch(JDBCException ex) {
			LOGGER.info("Exception Occured at the method userLogin()"  + ex.getMessage());
			return "Check Username or password";
		}
		catch(AssignmentServiceException ex) {
			LOGGER.info("Exception Occured at the method userLoginn()"  + ex.getMessage());
			return "Check Username or password";
		}
	}

}
