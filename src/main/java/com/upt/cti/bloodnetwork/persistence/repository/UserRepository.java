package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.cti.bloodnetwork.persistence.domain.entity.User;

@Repository("userRepository")
public class UserRepository {
	
	private final GenericRepository<User> genericRepository;

	@Autowired
	public UserRepository(GenericRepository<User> genericRepository) {
		this.genericRepository = genericRepository;
	}
	
	public void saveOne(User user) {
		genericRepository.saveIfNotPresent(user);
	}

	public Optional<User> findOne(String email) {
		return Optional.ofNullable(genericRepository.findOne(User.class, email));
	}
}
