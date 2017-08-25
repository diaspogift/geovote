package com.geovote.data.intf;

import com.geovote.rest.representation.CountRecordRepresentation;

public interface VoteDao {
	

	public CountRecordRepresentation countVotes(String code);

}
