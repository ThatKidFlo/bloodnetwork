package com.upt.cti.bloodnetwork.persistence.domain.converter;

import org.springframework.stereotype.Component;

import com.upt.cti.bloodnetwork.persistence.domain.dto.LatLongDTO;
import com.upt.cti.bloodnetwork.persistence.domain.dto.UserDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodType;
import com.upt.cti.bloodnetwork.persistence.domain.entity.LatLong;
import com.upt.cti.bloodnetwork.persistence.domain.entity.User;

@Component("userConverter")
public class UserConverter implements EntityConverter<User, UserDTO> {

	@Override
	public UserDTO marshall(User entity) {
		final UserDTO userDto = new UserDTO();
		
		userDto.setEmail(entity.getEmail());
		userDto.setName(entity.getName());
		userDto.setWeight(entity.getWeight());
		userDto.setPassword(entity.getPassword());
		userDto.setLocation(LatLongDTO.from(entity.getLocation()));
		userDto.setBloodType(entity.getBloodType().name());
		
		return userDto;
	}

	@Override
	public User unmarshall(UserDTO entityDTO) {
		final User user = new User();
		
		user.setEmail(entityDTO.getEmail());
		user.setName(entityDTO.getName());
		user.setWeight(entityDTO.getWeight());
		user.setPassword(entityDTO.getPassword());
		user.setLocation(LatLong.from(entityDTO.getLocation()));
		user.setBloodType(Enum.valueOf(BloodType.class, entityDTO.getBloodType()));
		
		return user;
	}
}
