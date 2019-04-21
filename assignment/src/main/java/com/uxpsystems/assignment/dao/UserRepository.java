package com.uxpsystems.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.uxpsystems.assignment.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	
}
