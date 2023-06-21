package com.um.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.entity.UserEntity;

@Repository
public interface UserEntityRepo  extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByEmail(String email);
}
