package com.rrmm.lancecell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmm.lancecell.models.Language;
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
		Optional<Project> optionalProject = projectRepository.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
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
	 public List<Project> allProjects() {
	     return projectRepository.findAll();
	 }
	
	 public List<Project> getProjectsByLanguage(Language lang){
		 return projectRepository.findAllByLanguage(lang);
	 }
}
