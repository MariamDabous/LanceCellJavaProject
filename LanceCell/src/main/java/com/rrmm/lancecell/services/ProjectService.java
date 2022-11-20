package com.rrmm.lancecell.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmm.lancecell.models.Project;
import com.rrmm.lancecell.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public Project create(Project project) {
		return projectRepository.save(project);
	}
	public void delete(Project project) {
		projectRepository.delete(project);
	}
	public Project find(Long id) {
		Optional<Project> opProject = projectRepository.findById(id);
		if(opProject.isPresent()) {
			return opProject.get();
		}
		else {
			return null;
		}
	}
	public Project update(Project project) {
		Optional<Project> opProject = projectRepository.findById(project.getId());
		if(opProject.isPresent()) {
			return projectRepository.save(project);
		}
		else {
			return null;
		}
		
	}
	
}
