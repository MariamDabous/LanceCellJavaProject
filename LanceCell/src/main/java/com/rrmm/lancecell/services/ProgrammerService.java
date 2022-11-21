package com.rrmm.lancecell.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.rrmm.lancecell.models.LoginUser;
import com.rrmm.lancecell.models.Programmer;
import com.rrmm.lancecell.repositories.ProgrammerRepository;

@Service
public class ProgrammerService {
	@Autowired
	ProgrammerRepository programmerRepository;
	

	public Programmer find(Long id) {
		Optional<Programmer> opProgrammer = programmerRepository.findById(id);
		if(opProgrammer.isPresent()) {
			return opProgrammer.get();
		}
		else {
			return null;
		}
	}
	public Programmer register(Programmer newProgrammer, BindingResult result) {
		if(programmerRepository.findByEmail(newProgrammer.getEmail()).isPresent()) {
			result.rejectValue( "email", "Unique", "This email is already in use!");
		}
		if(!newProgrammer.getPassword().equals(newProgrammer.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm pwd must match pwd!");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashedPwd = BCrypt.hashpw(newProgrammer.getPassword(), BCrypt.gensalt());
			newProgrammer.setPassword(hashedPwd);
			return programmerRepository.save(newProgrammer);
		}
	}
	
	public Programmer login(LoginUser newLogin,BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<Programmer> potentialProgrammer = programmerRepository.findByEmail(newLogin.getEmail());
		if(!potentialProgrammer.isPresent()) {
			result.rejectValue("email", "Unique", "Email or Pwd wrong");
			return null;
		}
		Programmer user = potentialProgrammer.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Email or Pwd wrong");
			return null;
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
	}
}
