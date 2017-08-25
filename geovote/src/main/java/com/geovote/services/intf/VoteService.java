package com.geovote.services.intf;

import com.geovote.rest.representation.CountRecordRepresentation;

public interface VoteService {
	
	public CountRecordRepresentation countPollingStationVotes(String code);

}
