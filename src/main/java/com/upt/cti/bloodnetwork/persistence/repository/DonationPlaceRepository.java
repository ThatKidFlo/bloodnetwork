package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPlace;

@Repository("donationPlaceRepository")
public class DonationPlaceRepository {

	private final GenericRepository<DonationPlace> genericRepo;

	@Autowired
	public DonationPlaceRepository(GenericRepository<DonationPlace> genericRepo) {
		this.genericRepo = genericRepo;
	}
	
	public void saveOne(DonationPlace entity) {
		genericRepo.saveIfNotPresent(entity);
	}

	public Optional<DonationPlace> findOne(Long pk) {
		return Optional.ofNullable(genericRepo.findOne(DonationPlace.class, pk));
	}
}
