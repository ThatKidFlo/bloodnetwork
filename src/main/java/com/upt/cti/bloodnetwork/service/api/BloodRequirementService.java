package com.upt.cti.bloodnetwork.service.api;

import java.util.List;

import com.upt.cti.bloodnetwork.persistence.domain.dto.BloodRequirementDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirement;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirementPk;

public interface BloodRequirementService extends GenericCRUDService<BloodRequirementPk, BloodRequirement, BloodRequirementDTO> {

	List<BloodRequirementDTO> findAllByBloodType(String bloodType);
}
