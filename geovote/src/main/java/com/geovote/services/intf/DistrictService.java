package com.geovote.services.intf;

import java.util.List;

import com.geovote.domain.context.administrative.District;

public interface DistrictService {
	
	public void createNewDistrict(District newDistrict);
	public void deleteExistingDistrict(District districtToDelete);
	public List<District> retrieveAllDistricts();
	public District findDistrictByCode(String string);

}
