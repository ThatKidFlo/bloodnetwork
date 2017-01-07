package com.upt.cti.bloodnetwork.web.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.cti.bloodnetwork.persistence.domain.dto.BloodRequirementDTO;
import com.upt.cti.bloodnetwork.service.api.BloodRequirementService;

@RestController
@RequestMapping("/bloodrequirement")
public class BloodRequirementEndpoint {
	
	private final BloodRequirementService bloodRequirementService;

	@Autowired
	public BloodRequirementEndpoint(BloodRequirementService bloodRequirementService) {
		this.bloodRequirementService = bloodRequirementService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 value = "/create")
	public void createBloodRequirement(@RequestBody BloodRequirementDTO bloodRequirement) {
		bloodRequirementService.createOne(bloodRequirement);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				value = "/find/{bloodType}")
	public List<BloodRequirementDTO> findBloodRequirementsByType(@PathVariable("bloodType") String bloodType) {
		return bloodRequirementService.findAllByBloodType(bloodType);
	}
}
