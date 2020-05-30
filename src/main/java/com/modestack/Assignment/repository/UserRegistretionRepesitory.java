package com.modestack.Assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modestack.Assignment.entity.Register;

@Repository
public interface UserRegistretionRepesitory extends JpaRepository<Register, Integer> {
	
	public List<Register> findAll();

}
