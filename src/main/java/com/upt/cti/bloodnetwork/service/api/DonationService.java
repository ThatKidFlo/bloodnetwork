package com.upt.cti.bloodnetwork.service.api;

import java.util.List;

import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationDTO;
import com.upt.cti.bloodnetwork.persistence.domain.entity.Donation;
import com.upt.cti.bloodnetwork.persistence.domain.entity.DonationPk;

public interface DonationService extends GenericCRUDService<DonationPk, Donation, DonationDTO> {

	List<DonationDTO> findAllByUserId(String email);
}
