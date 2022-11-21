package com.rrmm.lancecell.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmm.lancecell.models.Owner;
import com.rrmm.lancecell.repositories.OwnerRepository;

@Service
public class OwnerService {
	@Autowired
	OwnerRepository ownerRepository;
	
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}
	public Owner find(Long id) {
		Optional<Owner> opOwner = ownerRepository.findById(id);
		if(opOwner.isPresent()) {
			return opOwner.get();
		}
		else {
			return null;
		}
	}
	public Owner update(Owner owner) {
		Optional<Owner> opOwner = ownerRepository.findById(owner.getId());
		if(opOwner.isPresent()) {
			return ownerRepository.save(owner);
		}
		else {
			return null;
		}
		
	}
}
