package com.upt.cti.bloodnetwork.persistence.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationPlaceDTO;
import com.upt.cti.bloodnetwork.persistence.domain.dto.LatLongDTO;
import com.upt.cti.bloodnetwork.persistence.domain.dto.OrganizationDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPlace;
import com.upt.cti.bloodnetwork.persistence.domain.entity.LatLong;
import com.upt.cti.bloodnetwork.persistence.domain.entity.Organization;

public class DonationPlaceConverter implements EntityConverter<DonationPlace, DonationPlaceDTO>{
	
	@Autowired
	private EntityConverter<Organization, OrganizationDTO> organizationConverter;
	
	@Override
	public DonationPlaceDTO marshall(DonationPlace entity) {
		final DonationPlaceDTO donationPlace = new DonationPlaceDTO();
		
		donationPlace.setId(entity.getId());
		donationPlace.setName(entity.getName());
		donationPlace.setLocation(LatLongDTO.from(entity.getLocation()));
		donationPlace.setOrganization(organizationConverter.marshall(entity.getOrganization()));
		
		return donationPlace;
	}

	@Override
	public DonationPlace unmarshall(DonationPlaceDTO entityDTO) {
		final DonationPlace donationPlace = new DonationPlace();
		
		donationPlace.setId(entityDTO.getId());
		donationPlace.setLocation(LatLong.from(entityDTO.getLocation()));
		donationPlace.setName(entityDTO.getName());
		donationPlace.setOrganization(organizationConverter.unmarshall(entityDTO.getOrganization()));
		
		return donationPlace;
	}

}
