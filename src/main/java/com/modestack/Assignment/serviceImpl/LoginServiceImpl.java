package com.modestack.Assignment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modestack.Assignment.entity.Login;
import com.modestack.Assignment.entity.Register;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;
import com.modestack.Assignment.repository.UserRegistretionRepesitory;
import com.modestack.Assignment.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
//	@Autowired
//	UserLoginRepository loginRepository;
	
	@Autowired
	UserRegistretionRepesitory regRepository;

	@Override
	public String userLogin(Login login) throws AssignmentServiceException {
		
		LOGGER.info("Inside the method of userLogin() in ServiceImpl");
		String msg = "";
		int flag = 0;
		
		try {
			List<Register> listRegister = new ArrayList<Register>();
			listRegister = regRepository.findAll();
			
			for(int i=0; i<listRegister.size(); i++) {
				
				if(listRegister.get(i).getUserName().equals(login.getUserName()) && 
						listRegister.get(i).getPassword().equals(login.getPassword())) {
						
					flag++;
					msg = "Success";
					break;
				}
			}
			if(flag == 0) {
				msg = "Check Username or password";
			}
		}
		catch(Exception ex) {
			LOGGER.info("Exception occured in the method addUser() in ServiceImpl Class " +ex.getMessage());
			throw new AssignmentServiceException("Unable to add user");
		}

		return msg;
	}

}
