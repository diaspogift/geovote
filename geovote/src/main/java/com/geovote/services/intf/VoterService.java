package com.geovote.services.intf;

import java.util.List;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;

public interface VoterService {
	
	public void createNewVoter(Voter newVoter);
	public void deleteExistingVoter(Voter voterToDelete);
	public void updateExixstingVoter(Voter voterToUpdate);
	public List<Voter> retrieveAllVoters();
	public Voter findVoterByVoterId(String voterId);
	public Voter findVoterByApplicantId(String voterId);
	public PollingStation findVotersPollingStationByVoterId(String voterid);
	public PollingStation findVotersPollingStationByApplicantId(String voterid);

}
