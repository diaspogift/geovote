package com.geovote.services.intf;

import com.geovote.domain.context.election.Candidate;

public interface CandidateService {


	public  Candidate findCadidateByCode(String candidateRegistrationId);

	public void createCandidatesThemePercentages(String code, String candidateId);


    public void createNewCandidate(Candidate can1);
}
