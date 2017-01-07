package com.upt.cti.bloodnetwork.persistence.domain.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Donation")
public class Donation {
	
	@EmbeddedId
	private DonationPk pk;
	
	@Column
	private Date nextDonation;
	
	@Column
	private long quantity;

	public DonationPk getPk() {
		return pk;
	}

	public void setPk(DonationPk pk) {
		this.pk = pk;
	}

	public Date getNextDonation() {
		return nextDonation;
	}

	public void setNextDonation(Date nextDonation) {
		this.nextDonation = nextDonation;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
