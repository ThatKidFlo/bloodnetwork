package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPlace;
import com.upt.cti.bloodnetwork.service.util.CollectionUtils;
import com.upt.cti.bloodnetwork.service.util.Pair;

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

	public Optional<DonationPlace> findOneByName(String name) {
		final TypedQuery<DonationPlace> query = genericRepo
				.bindNamedQueryWithParams("DonationPlace.findByName", 
						DonationPlace.class, 
						CollectionUtils.pairsToMap(Pair.of("name", name)));
		
		final List<DonationPlace> result = query.getResultList();
		
		
		return result.isEmpty() ? Optional.empty() : Optional.ofNullable(result.get(0));
	}
}
