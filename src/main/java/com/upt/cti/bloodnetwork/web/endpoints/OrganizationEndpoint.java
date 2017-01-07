package com.upt.cti.bloodnetwork.web.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.cti.bloodnetwork.persistence.domain.dto.OrganizationDTO;
import com.upt.cti.bloodnetwork.service.api.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationEndpoint {

	private final OrganizationService organizationService;

	@Autowired
	public OrganizationEndpoint(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 value = "/create")
	public void createUser(@RequestBody OrganizationDTO org) {
		organizationService.createOne(org);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				value = "/find/{id}")
	public OrganizationDTO findUser(@PathVariable("id") long id) {
		return organizationService.findOne(id);
	}
}
