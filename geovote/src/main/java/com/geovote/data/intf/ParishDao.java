package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.administrative.Parish;
import com.geovote.domain.context.administrative.Voter;

public interface ParishDao {
	
	public void create(Parish parish);
	public void delete(Parish parish);
	public List<Voter> getParishesVotersByParhishCode(String code);
	public Parish getParishByCode(String code);
	public List<Parish> getAllParishes();

}
