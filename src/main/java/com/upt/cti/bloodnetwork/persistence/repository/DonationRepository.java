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
	private final GenericRepository<Date> genericDateRepo;

	@Autowired
	public DonationRepository(GenericRepository<Donation> genericRepo,
							  GenericRepository<Date> genericDateRepo) {
		this.genericRepo = genericRepo;
		this.genericDateRepo = genericDateRepo;
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
		final TypedQuery<Date> query = genericDateRepo
				.bindNamedQueryWithParams("Donation.findNextDateByUserId", 
						Date.class, 
						CollectionUtils.pairsToMap(Pair.of("userId", email)));
		
		final List<Date> result = query.getResultList();
		
		return result.isEmpty() ? Optional.empty() : Optional.ofNullable(result.get(0));
	}
}
