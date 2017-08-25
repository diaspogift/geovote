package com.geovote.services.intf;

import java.util.List;

import com.geovote.domain.context.administrative.Constituency;

public interface ConstituencyService {
	
	
	public void createNewDConstituency(Constituency constituency);
	public void deleteExistingConstituency(Constituency constituency);
	public List<Constituency> retrieveAllConstituencies();
	public Constituency findConstituencyByCode(String code);

}
