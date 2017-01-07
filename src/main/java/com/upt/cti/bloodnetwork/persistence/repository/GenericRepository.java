package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.Map;

import javax.persistence.TypedQuery;

public interface GenericRepository<E> {
	<PK> E findOne(Class<E> entityClazz, PK primaryKey);

	TypedQuery<E> bindNamedQueryWithParams(String queryId, Class<E> entityClazz, Map<String, Object> params);

	void delete(E entity);

	void saveIfNotPresent(E entity);

	void saveOrUpdate(E entity);
}
