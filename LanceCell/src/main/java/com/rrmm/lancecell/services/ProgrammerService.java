package com.rrmm.lancecell.services;

import java.util.List;
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
	private ProgrammerRepository programmerRepository;
	
	
	public Programmer register(Programmer newUser, BindingResult result) {
		if(programmerRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue( "email", "Unique", "This email is already in use!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm pwd must match pwd!");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashedPwd = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPwd);
			return programmerRepository.save(newUser);
		}
	}
	
	public Programmer login(LoginUser newLogin,BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<Programmer> potentialUser = programmerRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Email or Pwd wrong");
			return null;
		}
		Programmer user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Email or Pwd wrong");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
	}
	
	public List<Programmer> all(){
		return programmerRepository.findAll();
	}
	
	public Programmer get(Long id) {
		Optional<Programmer> opUser= programmerRepository.findById(id);
		if(opUser.isPresent()) {
			return opUser.get();
		}
		else {
			return null;
		}
	}
}
