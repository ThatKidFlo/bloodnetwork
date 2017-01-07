package com.upt.cti.bloodnetwork.service.core;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upt.cti.bloodnetwork.persistence.domain.converter.EntityConverter;
import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.Donation;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPk;
import com.upt.cti.bloodnetwork.persistence.domain.exception.MissingRequiredEntity;
import com.upt.cti.bloodnetwork.persistence.repository.DonationRepository;
import com.upt.cti.bloodnetwork.service.api.DonationService;

@Service("donationService")
public class DefaultDonationService implements DonationService {

	private final DonationRepository donationRepository;
	private final EntityConverter<Donation, DonationDTO> donationConverter;
	
	@Autowired
	public DefaultDonationService(DonationRepository donationRepository,
			EntityConverter<Donation, DonationDTO> donationConverter) {
		this.donationRepository = donationRepository;
		this.donationConverter = donationConverter;
	}

	@Override
	@Transactional
	public void createOne(DonationDTO form) {
		donationRepository.saveOne(donationConverter.unmarshall(form));
	}

	@Override
	public DonationDTO findOne(DonationPk pk) {
		return donationRepository
				.findOne(pk)
				.map(donationConverter::marshall)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find Donation for pk:: "+ pk));
	}

	@Override
	public List<DonationDTO> findAllByUserId(String email) {
		return donationRepository
				.findAll(email)
				.stream()
				.map(donationConverter::marshall)
				.collect(Collectors.toList());
	}
}
