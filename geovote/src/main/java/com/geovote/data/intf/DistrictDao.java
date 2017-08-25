package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.administrative.District;

public interface DistrictDao {
	
	public void create(District district);
	public void delete(District district);
	public List<District> allDistricts();
	public District getDistrictByCode(String code);
	

}
