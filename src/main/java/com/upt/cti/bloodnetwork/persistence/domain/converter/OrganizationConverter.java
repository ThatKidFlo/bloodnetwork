package com.upt.cti.bloodnetwork.persistence.domain.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	private <E, M> List<M> mapList(List<E> entitiesList, Function<E, M> mapper) {
		return entitiesList
				.stream()
				.map(mapper)
				.collect(Collectors.toList());
	}
}
