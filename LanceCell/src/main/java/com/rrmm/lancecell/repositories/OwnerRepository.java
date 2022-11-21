package com.rrmm.lancecell.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rrmm.lancecell.models.Owner;
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
	List<Owner> findAll();
	Optional<Owner> findByEmail(String email);
}
