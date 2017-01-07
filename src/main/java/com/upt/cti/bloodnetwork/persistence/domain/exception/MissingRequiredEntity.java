package com.upt.cti.bloodnetwork.persistence.domain.exception;

public class MissingRequiredEntity extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MissingRequiredEntity(String message) {
		super(message);
	}
}
