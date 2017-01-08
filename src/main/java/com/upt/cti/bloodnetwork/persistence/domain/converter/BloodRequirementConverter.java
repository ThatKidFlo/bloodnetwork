package com.upt.cti.bloodnetwork.persistence.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upt.cti.bloodnetwork.persistence.domain.dto.BloodRequirementDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirement;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirementPk;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodType;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPlace;
import com.upt.cti.bloodnetwork.persistence.domain.entity.PriorityType;
import com.upt.cti.bloodnetwork.persistence.domain.exception.MissingRequiredEntity;
import com.upt.cti.bloodnetwork.persistence.repository.DonationPlaceRepository;

@Component("bloodRequirementConverter")
public class BloodRequirementConverter implements EntityConverter<BloodRequirement, BloodRequirementDTO> {

	private final DonationPlaceRepository donationPlaceRepository;
	
	@Autowired
	public BloodRequirementConverter(DonationPlaceRepository donationPlaceRepository) {
		this.donationPlaceRepository = donationPlaceRepository;
	}

	@Override
	public BloodRequirementDTO marshall(BloodRequirement entity) {
		final BloodRequirementDTO bloodReq = new BloodRequirementDTO();
		
		bloodReq.setPlaceName(getDonationPlaceNameFrom(entity.getPk().getPlaceId()));
		bloodReq.setBloodType(entity.getPk().getBloodType().name());
		bloodReq.setPriority(entity.getPriority().name());
		bloodReq.setQuantity(entity.getQuantity());
		
		return bloodReq;
	}

	private String getDonationPlaceNameFrom(long donationPlaceId) {
		return donationPlaceRepository
				.findOne(donationPlaceId)
				.map(DonationPlace::getName)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find donation place for id:: " + donationPlaceId));
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
		bloodReqPk.setPlaceId(getDonationPlaceIdFrom(entityDTO.getPlaceName()));
		bloodReqPk.setBloodType(Enum.valueOf(BloodType.class, entityDTO.getBloodType()));
		return bloodReqPk;
	}
	
	private long getDonationPlaceIdFrom(String name) {
		return donationPlaceRepository
				.findOneByName(name)
				.map(DonationPlace::getId)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find donation place for name:: " + name));
	}
}
