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

import com.modestack.Assignment.entity.Register;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;
import com.modestack.Assignment.service.RegistrationService;

@RestController
public class UserRegistrationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String userRegistration(@RequestBody Register register) {
		LOGGER.info("Inside the method of userRegistration()");
		
		try {
			registrationService.addUser(register);
			LOGGER.info("Exit from the method of userRegistration()");
			return "new User Created";
		}
		catch(JDBCException ex) {
			LOGGER.info("Exception Occured at the method userRegistration()"  + ex.getMessage());
			return "Unable to add User";
		}
		catch(AssignmentServiceException ex) {
			LOGGER.info("Exception Occured at the method userRegistration()"  + ex.getMessage());
			return "Unable to add User";
		}
	
	}
	
}
