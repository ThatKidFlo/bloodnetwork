package com.upt.cti.bloodnetwork.persistence.domain.converter;

import org.springframework.stereotype.Component;

import com.upt.cti.bloodnetwork.persistence.domain.dto.BloodRequirementDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirement;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirementPk;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodType;
import com.upt.cti.bloodnetwork.persistence.domain.entity.PriorityType;

@Component("bloodRequirementConverter")
public class BloodRequirementConverter implements EntityConverter<BloodRequirement, BloodRequirementDTO> {

	@Override
	public BloodRequirementDTO marshall(BloodRequirement entity) {
		final BloodRequirementDTO bloodReq = new BloodRequirementDTO();
		
		bloodReq.setPlaceId(entity.getPk().getPlaceId());
		bloodReq.setBloodType(entity.getPk().getBloodType().name());
		bloodReq.setPriority(entity.getPriority().name());
		bloodReq.setQuantity(entity.getQuantity());
		
		return bloodReq;
	}

	@Override
	public BloodRequirement unmarshall(BloodRequirementDTO entityDTO) {
		final BloodRequirement bloodReq = new BloodRequirement();
		
		bloodReq.setPk(buildPkFrom(entityDTO));
		bloodReq.setQuantity(entityDTO.getQuantity());
		bloodReq.setPriority(Enum.valueOf(PriorityType.class, entityDTO.getPriority()));
		
		return bloodReq;
	}

	private BloodRequirementPk buildPkFrom(BloodRequirementDTO entityDTO) {
		final BloodRequirementPk bloodReqPk = new BloodRequirementPk();
		bloodReqPk.setPlaceId(entityDTO.getPlaceId());
		bloodReqPk.setBloodType(Enum.valueOf(BloodType.class, entityDTO.getBloodType()));
		return bloodReqPk;
	}
}
