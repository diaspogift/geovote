package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.administrative.Voter;

public interface VoterDao {

	public void create(Voter newVoter);

	public void update(Voter voterToUpdate);

	public void delete(Voter voterToDelete);

	public List<Voter> getAllVoters();
	
	public Voter getVoterById(String id);
		
	public List<Voter> getVoterByName(String name);

	public Voter getVoterByApplicantId(String applicantId);

	
	

}
