package com.scb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUsername(String username);
}
