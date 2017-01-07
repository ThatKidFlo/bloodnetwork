package com.upt.cti.bloodnetwork.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upt.cti.bloodnetwork.persistence.domain.converter.EntityConverter;
import com.upt.cti.bloodnetwork.persistence.domain.dto.UserDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.User;
import com.upt.cti.bloodnetwork.persistence.domain.exception.MissingRequiredEntity;
import com.upt.cti.bloodnetwork.persistence.repository.UserRepository;
import com.upt.cti.bloodnetwork.service.api.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;
	private final EntityConverter<User, UserDTO> userConverter;
	
	@Autowired
	public DefaultUserService(UserRepository userRepository, 
							  EntityConverter<User, UserDTO> userConverter) {
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}

	@Override
	@Transactional
	public void createOne(UserDTO userForm) {
		userRepository.saveOne(userConverter.unmarshall(userForm));
	}

	@Override
	public UserDTO findOne(String email) {
		final User userEntity = userRepository
				.findOne(email)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find user with email:: " + email));
		
		return userConverter.marshall(userEntity);
	}
}
