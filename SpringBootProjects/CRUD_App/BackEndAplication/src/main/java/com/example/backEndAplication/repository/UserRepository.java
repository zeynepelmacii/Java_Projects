package com.example.backEndAplication.repository;

import com.example.backEndAplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
	
}