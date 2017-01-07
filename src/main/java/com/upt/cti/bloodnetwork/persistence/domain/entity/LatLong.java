package com.upt.cti.bloodnetwork.persistence.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.upt.cti.bloodnetwork.persistence.domain.dto.LatLongDTO;

@Embeddable
public class LatLong implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public static LatLong of(double latitude, double longitude) {
		final LatLong ll = new LatLong();
		
		ll.setLatitude(latitude);
		ll.setLongitude(longitude);
		
		return ll;
	}
	
	public static LatLong from(LatLongDTO latLong) {
		return of(latLong.getLatitude(), latLong.getLongitude());
	}
}
