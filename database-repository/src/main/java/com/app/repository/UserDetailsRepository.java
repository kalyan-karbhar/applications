package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

	List<UserDetails> findAll();
	
	Optional<UserDetails> findById(Integer id);


}
