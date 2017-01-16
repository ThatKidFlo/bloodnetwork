package com.upt.cti.bloodnetwork.persistence.repository;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.cti.bloodnetwork.persistence.domain.entity.Donation;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPk;
import com.upt.cti.bloodnetwork.service.util.CollectionUtils;
import com.upt.cti.bloodnetwork.service.util.Pair;

@Repository("donationRepository")
public class DonationRepository {

	private final GenericRepository<Donation> genericRepo;

	@Autowired
	public DonationRepository(GenericRepository<Donation> genericRepo) {
		this.genericRepo = genericRepo;
	}
	
	public void saveOne(Donation entity) {
		genericRepo.saveIfNotPresent(entity);
	}

	public Optional<Donation> findOne(DonationPk pk) {
		return Optional.ofNullable(genericRepo.findOne(Donation.class, pk));
	}

	public List<Donation> findAll(String email) {
		final TypedQuery<Donation> query = genericRepo
				.bindNamedQueryWithParams("Donation.findByUserId", 
						Donation.class, 
						CollectionUtils.pairsToMap(Pair.of("userId", email)));
		
		return Collections.unmodifiableList(query.getResultList());
	}
	
	public Optional<Date> findLatest(String email) {
		return null;
	}
}
