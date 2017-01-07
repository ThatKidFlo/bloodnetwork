package com.upt.cti.bloodnetwork.persistence.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "BloodRequirement")
public class BloodRequirement {
	
	@EmbeddedId
	private BloodRequirementPk pk;
	
	@Column
	private long quantity;
	
	@Enumerated(EnumType.STRING)
	@Column
	private PriorityType priority;

	public BloodRequirementPk getPk() {
		return pk;
	}

	public void setPk(BloodRequirementPk pk) {
		this.pk = pk;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		this.priority = priority;
	}
}
