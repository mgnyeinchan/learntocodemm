package com.learntocodemm.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learntocodemm.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query("select usr from Users usr where usr.name=?1")	
	Users findByname(String name);
}
