package com.modestack.Assignment.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modestack.Assignment.entity.Register;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;
import com.modestack.Assignment.repository.UserRegistretionRepesitory;
import com.modestack.Assignment.service.RegistrationService;


@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	@Autowired
	UserRegistretionRepesitory registrationRepo;

	@Override
	public List<Register> addUser(Register register) throws AssignmentServiceException {
		LOGGER.info("Inside the method of addUser()");
		try {
			
			registrationRepo.save(register);
			LOGGER.info("Exit from the method of addUser()");
		}
		catch(Exception ex) {
			LOGGER.info("Exception occured in the method addUser() " +ex.getMessage());
			throw new AssignmentServiceException("Unable to add user");
		}
		
		return null;
	}

}
