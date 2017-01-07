package com.upt.cti.bloodnetwork.persistence.repository;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("genericRepository")
public class DefaultGenericRepository<E> implements GenericRepository<E> {

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public <PK> E findOne(Class<E> entityClazz, PK primaryKey) {
		return entityManager.find(entityClazz, primaryKey);
	}

	@Override
	public TypedQuery<E> bindNamedQueryWithParams(String queryId, Class<E> entityClazz, Map<String, Object> params) {
		final TypedQuery<E> query = entityManager.createNamedQuery(queryId, entityClazz);
		
		params
			.entrySet()
			.stream()
			.forEach(paramEntry -> query.setParameter(paramEntry.getKey(), paramEntry.getValue()));
		
		return query;
	}

	@Override
	public void delete(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public void saveIfNotPresent(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		entityManager.merge(entity);
	}

}
