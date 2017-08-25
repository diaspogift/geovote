package com.geovote.services.intf;

import java.util.List;

import com.geovote.domain.context.administrative.Parish;
import com.geovote.domain.context.administrative.Voter;

public interface ParishService {
	
	public void createNewParish(Parish newParish);
	public void deleteExistingDistrict(Parish parishToDelete);
	public Parish getParishByCode(String code);
	public List<Voter> findParichesVotersByParishCode(String code);
	List<Parish> getAllParishes();


}
