package com.geovote.services.impl;

import com.geovote.services.intf.VoteService;
import org.springframework.beans.factory.annotation.Autowired;

import com.geovote.data.intf.VoteDao;
import com.geovote.rest.representation.CountRecordRepresentation;

public class VoteServiceImpl  implements VoteService {

	@Autowired
	private VoteDao dao;
	
	
	
	@Override
	public CountRecordRepresentation countPollingStationVotes(String code) {
		return dao.countVotes(code);
	}

}
