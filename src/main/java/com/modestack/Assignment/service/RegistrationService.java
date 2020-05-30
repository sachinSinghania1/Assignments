package com.modestack.Assignment.service;

import java.util.List;

import com.modestack.Assignment.entity.Register;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;

public interface RegistrationService {
	
	public List<Register> addUser(Register register) throws AssignmentServiceException;

}
