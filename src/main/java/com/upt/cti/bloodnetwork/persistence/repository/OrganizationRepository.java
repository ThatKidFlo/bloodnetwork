package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.cti.bloodnetwork.persistence.domain.entity.Organization;

@Repository("organizationRepository")
public class OrganizationRepository {

	private final GenericRepository<Organization> genericRepo;

	@Autowired
	public OrganizationRepository(GenericRepository<Organization> genericRepo) {
		this.genericRepo = genericRepo;
	}

	public void saveOne(Organization entity) {
		genericRepo.saveIfNotPresent(entity);
	}

	public Optional<Organization> findOne(Long pk) {
		return Optional.ofNullable(genericRepo.findOne(Organization.class, pk));
	}
}
