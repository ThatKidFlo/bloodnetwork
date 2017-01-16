package com.upt.cti.bloodnetwork.persistence.domain.converter;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.Donation;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPk;

@Component("donationConverter")
public class DonationConverter implements EntityConverter<Donation, DonationDTO>{

	@Override
	public DonationDTO marshall(Donation entity) {
		final DonationDTO donation = new DonationDTO();
		
		donation.setDate(entity.getPk().getDate());
		donation.setNextDonation(entity.getNextDonation());
		donation.setPlaceId(entity.getPk().getPlaceId());
		donation.setUserId(entity.getPk().getUserId());
		donation.setQuantity(entity.getQuantity());
		
		return donation;
	}

	@Override
	public Donation unmarshall(DonationDTO entityDTO) {
		final Donation donation = new Donation();
		
		donation.setPk(pkFrom(entityDTO));
		donation.setNextDonation(computeNextDonationDate(entityDTO)); //TODO:: set this!
		donation.setQuantity(entityDTO.getQuantity());
		
		return donation;
	}

	private Date computeNextDonationDate(DonationDTO entityDTO) {
		final Calendar nextDate = Calendar.getInstance();
		nextDate.setTime(entityDTO.getDate());
		nextDate.add(Calendar.MONTH, 5);
		return new Date(nextDate.getTimeInMillis());
	}

	private DonationPk pkFrom(DonationDTO entityDTO) {
		final DonationPk pk = new DonationPk();
		
		pk.setDate(entityDTO.getDate());
		pk.setPlaceId(entityDTO.getPlaceId());
		pk.setUserId(entityDTO.getUserId());
		
		return pk;
	}
}
