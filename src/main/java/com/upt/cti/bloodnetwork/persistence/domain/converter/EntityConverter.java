package com.upt.cti.bloodnetwork.persistence.domain.converter;

public interface EntityConverter<E, DTO> {

	DTO marshall(E entity);

	E unmarshall(DTO entityDTO);
}
