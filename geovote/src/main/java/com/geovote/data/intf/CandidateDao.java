package com.geovote.data.intf;

import com.geovote.domain.context.election.Candidate;

public interface CandidateDao {

	void create(Candidate can1);

	Candidate findCandidateByCode(String candidateRegistrationId);
	
	Candidate findElectionCandidateByCode(String code,String candidateRegistrationId);


}
