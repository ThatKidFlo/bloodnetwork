package com.upt.cti.bloodnetwork.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upt.cti.bloodnetwork.persistence.domain.converter.EntityConverter;
import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationPlaceDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPlace;
import com.upt.cti.bloodnetwork.persistence.domain.exception.MissingRequiredEntity;
import com.upt.cti.bloodnetwork.persistence.repository.DonationPlaceRepository;
import com.upt.cti.bloodnetwork.service.api.DonationPlaceService;

@Service("donationPlaceService")
public class DefaultDonationPlaceService implements DonationPlaceService {

	private final DonationPlaceRepository donationPlaceRepository;
	private final EntityConverter<DonationPlace, DonationPlaceDTO> donationPlaceConverter;
	
	@Autowired
	public DefaultDonationPlaceService(DonationPlaceRepository donationPlaceRepository,
			EntityConverter<DonationPlace, DonationPlaceDTO> donationPlaceConverter) {
		this.donationPlaceRepository = donationPlaceRepository;
		this.donationPlaceConverter = donationPlaceConverter;
	}

	@Override
	@Transactional
	public void createOne(DonationPlaceDTO form) {
		donationPlaceRepository.saveOne(donationPlaceConverter.unmarshall(form));
	}

	@Override
	public DonationPlaceDTO findOne(Long pk) {
		return donationPlaceRepository
				.findOne(pk)
				.map(donationPlaceConverter::marshall)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find donation place with id:: " + pk));
	}

}
