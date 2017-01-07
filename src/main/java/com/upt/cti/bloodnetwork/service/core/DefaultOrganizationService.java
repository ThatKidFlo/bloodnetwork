package com.upt.cti.bloodnetwork.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upt.cti.bloodnetwork.persistence.domain.converter.EntityConverter;
import com.upt.cti.bloodnetwork.persistence.domain.dto.OrganizationDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.Organization;
import com.upt.cti.bloodnetwork.persistence.domain.exception.MissingRequiredEntity;
import com.upt.cti.bloodnetwork.persistence.repository.OrganizationRepository;
import com.upt.cti.bloodnetwork.service.api.OrganizationService;

@Service("organizationService")
public class DefaultOrganizationService implements OrganizationService {

	private final OrganizationRepository organizationRepository;
	private final EntityConverter<Organization, OrganizationDTO> organizationConverter;
	
	@Autowired
	public DefaultOrganizationService(OrganizationRepository organizationRepository,
			EntityConverter<Organization, OrganizationDTO> organizationConverter) {
		this.organizationRepository = organizationRepository;
		this.organizationConverter = organizationConverter;
	}

	@Override
	@Transactional
	public void createOne(OrganizationDTO organizationForm) {
		organizationRepository.saveOne(organizationConverter.unmarshall(organizationForm));
	}

	@Override
	public OrganizationDTO findOne(Long pk) {
		return organizationRepository
				.findOne(pk)
				.map(organizationConverter::marshall)
				.orElseThrow(() -> new MissingRequiredEntity("Unable to find organization with id:: " + pk));
	}
}
