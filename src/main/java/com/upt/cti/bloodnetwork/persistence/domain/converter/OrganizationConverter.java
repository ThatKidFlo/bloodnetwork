package com.upt.cti.bloodnetwork.persistence.domain.converter;

import org.springframework.stereotype.Component;

import com.upt.cti.bloodnetwork.persistence.domain.dto.OrganizationDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.Organization;

@Component("organizationConverter")
public class OrganizationConverter implements EntityConverter<Organization, OrganizationDTO> {

	@Override
	public OrganizationDTO marshall(Organization entity) {
		final OrganizationDTO orgDto = new OrganizationDTO();
		
		orgDto.setId(entity.getId());
		orgDto.setName(entity.getName());
		
		return orgDto;
	}

	@Override
	public Organization unmarshall(OrganizationDTO entityDTO) {
		final Organization org = new Organization();
		
		org.setId(entityDTO.getId());
		org.setName(entityDTO.getName());
		
		return org;
	}
}
