package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.administrative.SubCounty;

public interface SubCountyDao {
	
	public void create(SubCounty subCounty);
	public void delete(SubCounty subCounty);
	public List<SubCounty> allSubCountyes();
	public SubCounty getSubCountyByCode(String code);

}
