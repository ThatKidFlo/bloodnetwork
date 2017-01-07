package com.upt.cti.bloodnetwork.persistence.domain.dto;

import java.util.List;

public class OrganizationDTO {

	private long id;
	private String name;
	private List<DonationPlaceDTO> donationPlaces;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DonationPlaceDTO> getDonationPlaces() {
		return donationPlaces;
	}

	public void setDonationPlaces(List<DonationPlaceDTO> donationPlaces) {
		this.donationPlaces = donationPlaces;
	}
}
