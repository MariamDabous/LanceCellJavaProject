package com.rrmm.lancecell.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmm.lancecell.models.Programmer;
import com.rrmm.lancecell.repositories.ProgrammerRepository;

@Service
public class ProgrammerService {
	@Autowired
	ProgrammerRepository programmerRepository;
	
	public Programmer create(Programmer programmer) {
		return programmerRepository.save(programmer);
	}
	public void delete(Programmer programmer) {
		programmerRepository.delete(programmer);
	}
	public Programmer find(Long id) {
		Optional<Programmer> opProgrammer = programmerRepository.findById(id);
		if(opProgrammer.isPresent()) {
			return opProgrammer.get();
		}
		else {
			return null;
		}
	}
	public Programmer update(Programmer programmer) {
		Optional<Programmer> opProgrammer = programmerRepository.findById(programmer.getId());
		if(opProgrammer.isPresent()) {
			return programmerRepository.save(programmer);
		}
		else {
			return null;
		}
		
	}
}
