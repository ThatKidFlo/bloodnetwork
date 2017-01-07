package com.upt.cti.bloodnetwork.persistence.domain.dto;

import com.upt.cti.bloodnetwork.persistence.domain.entity.LatLong;

public class LatLongDTO {

	private double latitude;
	private double longitude;

	public LatLongDTO() {}
	
	public LatLongDTO(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public static LatLongDTO of(double latitude, double longitude) {
		return new LatLongDTO(latitude, longitude);
	}
	
	public static LatLongDTO from(LatLong latLong) {
		return of(latLong.getLatitude(), latLong.getLongitude());
	}
}
