package com.rrmm.lancecell.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rrmm.lancecell.models.Project;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findAll();
	Project findByTitle(String title);
	
}
