package com.rrmm.lancecell.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.rrmm.lancecell.models.LoginUser;
import com.rrmm.lancecell.models.Owner;
import com.rrmm.lancecell.repositories.OwnerRepository;

@Service
public class OwnerService {
	@Autowired
	OwnerRepository ownerRepository;
	
	public Owner find(Long id) {
		Optional<Owner> opOwner = ownerRepository.findById(id);
		if(opOwner.isPresent()) {
			return opOwner.get();
		}
		else {
			return null;
		}
	}
	public Owner register(Owner newOwner, BindingResult result) {
		if(ownerRepository.findByEmail(newOwner.getEmail()).isPresent()) {
			result.rejectValue( "email", "Unique", "This email is already in use!");
		}
		if(!newOwner.getPassword().equals(newOwner.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm pwd must match pwd!");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashedPwd = BCrypt.hashpw(newOwner.getPassword(), BCrypt.gensalt());
			newOwner.setPassword(hashedPwd);
			return ownerRepository.save(newOwner);
		}
	}
	
	public Owner login(LoginUser newLogin,BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<Owner> potentialOwner = ownerRepository.findByEmail(newLogin.getEmail());
		if(!potentialOwner.isPresent()) {
			result.rejectValue("email", "Unique", "Email or Pwd wrong");
			return null;
		}
		Owner user = potentialOwner.get();
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
