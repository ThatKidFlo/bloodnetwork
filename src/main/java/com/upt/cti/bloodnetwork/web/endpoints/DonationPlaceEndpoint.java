package com.upt.cti.bloodnetwork.web.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationPlaceDTO;
import com.upt.cti.bloodnetwork.service.api.DonationPlaceService;

@RestController
@RequestMapping("/donationplace")
public class DonationPlaceEndpoint {

	private final DonationPlaceService donationPlaceService;

	@Autowired
	public DonationPlaceEndpoint(DonationPlaceService donationPlaceService) {
		this.donationPlaceService = donationPlaceService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 value = "/create")
	public void createUser(@RequestBody DonationPlaceDTO org) {
		donationPlaceService.createOne(org);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				value = "/find/{id}")
	public DonationPlaceDTO findUser(@PathVariable("id") long id) {
		return donationPlaceService.findOne(id);
	}
}
