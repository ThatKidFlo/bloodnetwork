package com.upt.cti.bloodnetwork.web.endpoints;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationDTO;
import com.upt.cti.bloodnetwork.service.api.DonationService;

@RestController
@RequestMapping("/donation")
public class DonationEndpoint {
	
	private final DonationService donationService;

	@Autowired
	public DonationEndpoint(DonationService donationService) {
		this.donationService = donationService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 value = "/create")
	public void createDonation(@RequestBody DonationDTO donation) {
		donationService.createOne(donation);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				value = "/find/{userEmail}")
	public List<DonationDTO> findUser(@PathVariable("userEmail") String email) {
		return donationService.findAllByUserId(email);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				value = "/next/{userEmail}")
	public Date nextDonationDateFor(@PathVariable("userEmail") String userEmail) {
		return donationService.nextDonationDateFor(userEmail);
	}
}
