package com.modestack.Assignment.service;

import com.modestack.Assignment.entity.Login;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;

public interface LoginService {
	
	public String userLogin(Login login) throws AssignmentServiceException;

}
