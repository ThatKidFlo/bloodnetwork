package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirement;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodRequirementPk;
import com.upt.cti.bloodnetwork.persistence.domain.entity.BloodType;
import com.upt.cti.bloodnetwork.service.util.CollectionUtils;
import com.upt.cti.bloodnetwork.service.util.Pair;

@Repository("bloodRequirementRepository")
public class BloodRequirementRepository {

	private final GenericRepository<BloodRequirement> genericRepo;

	@Autowired
	public BloodRequirementRepository(GenericRepository<BloodRequirement> genericRepo) {
		this.genericRepo = genericRepo;
	}

	public void saveOne(BloodRequirement entity) {
		genericRepo.saveIfNotPresent(entity);
	}

	public Optional<BloodRequirement> findOne(BloodRequirementPk pk) {
		return Optional.ofNullable(genericRepo.findOne(BloodRequirement.class, pk));
	}
	
	public List<BloodRequirement> findAllByBloodType(BloodType bloodType) {
		final TypedQuery<BloodRequirement> query = genericRepo
				.bindNamedQueryWithParams("BloodRequirement.findByBloodType", 
						BloodRequirement.class, 
						CollectionUtils.pairsToMap(Pair.of("bloodType", bloodType)));
		
		return Collections.unmodifiableList(query.getResultList());
	}
}
