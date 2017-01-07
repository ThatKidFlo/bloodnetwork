package com.upt.cti.bloodnetwork.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upt.cti.bloodnetwork.persistence.domain.converter.EntityConverter;
import com.upt.cti.bloodnetwork.persistence.domain.dto.BloodRequirementDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirement;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirementPk;
import com.upt.cti.bloodnetwork.persistence.domain.exception.MissingRequiredEntity;
import com.upt.cti.bloodnetwork.persistence.repository.BloodRequirementRepository;
import com.upt.cti.bloodnetwork.service.api.BloodRequirementService;

@Service("bloodRequirementService")
public class DefaultBloodRequirementService implements BloodRequirementService {

	private final BloodRequirementRepository bloodRequirementRepository;
	private final EntityConverter<BloodRequirement, BloodRequirementDTO> bloodRequirementConverter;
	
	@Autowired
	public DefaultBloodRequirementService(BloodRequirementRepository bloodRequirementRepository,
			EntityConverter<BloodRequirement, BloodRequirementDTO> bloodRequirementConverter) {
		this.bloodRequirementRepository = bloodRequirementRepository;
		this.bloodRequirementConverter = bloodRequirementConverter;
	}

	@Override
	@Transactional
	public void createOne(BloodRequirementDTO form) {
		bloodRequirementRepository.saveOne(bloodRequirementConverter.unmarshall(form));
	}

	@Override
	public BloodRequirementDTO findOne(BloodRequirementPk pk) {
		return bloodRequirementRepository
				.findOne(pk)
				.map(bloodRequirementConverter::marshall)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find blood requirement with pk:: " + pk));
	}

	@Override
	public List<BloodRequirementDTO> findAllByBloodType(String bloodType) {
		return null;
	}
}
