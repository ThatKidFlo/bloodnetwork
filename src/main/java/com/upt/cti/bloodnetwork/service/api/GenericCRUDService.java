package com.upt.cti.bloodnetwork.service.api;

public interface GenericCRUDService<P, E, D> {
	void createOne(D form);
	
	D findOne(P pk);
}
