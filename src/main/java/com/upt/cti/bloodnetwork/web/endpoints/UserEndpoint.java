package com.upt.cti.bloodnetwork.web.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.cti.bloodnetwork.persistence.domain.dto.UserDTO;
import com.upt.cti.bloodnetwork.service.api.UserService;

@RequestMapping("/user")
@RestController
public class UserEndpoint {
	
	final UserService userService;

	@Autowired
	public UserEndpoint(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 value = "/create")
	public void createUser(@RequestBody UserDTO user) {
		userService.createUser(user);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				value = "/find/{email}")
	public UserDTO findUser(@PathVariable("email") String email) {
		return userService.findOne(email);
	}
}
