package com.geovote.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.geovote.services.intf.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;
import com.geovote.data.intf.PollingStationDao;
import com.geovote.data.intf.VoterDao;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterDao voterDao;
	@Autowired
	private PollingStationDao pollingStationDao;
	
	

	public void createNewVoter(Voter newVoter) {
		voterDao.create(newVoter);
	}

	public void deleteExistingVoter(Voter voterToDelete) {
		voterDao.delete(voterToDelete);
	}

	public void updateExixstingVoter(Voter voterToUpdate) {
		voterDao.update(voterToUpdate);
	}

	public List<Voter> retrieveAllVoters() {

		return voterDao.getAllVoters();
	}

	@Override
	public Voter findVoterByVoterId(String voterId) {

		return voterDao.getVoterById(voterId);
	}
	
	@Override
	public Voter findVoterByApplicantId(String applicantId) {
		
		return voterDao.getVoterByApplicantId(applicantId);

	}


	@Override
	public PollingStation findVotersPollingStationByVoterId(String voterId) {

		Voter foundVoter = findVoterByVoterId(voterId);
		
		PollingStation foundVotersPollingStation = pollingStationDao.getPollingStationByCode(foundVoter.getPollingStationInfo().getPollingStationCode());
		
		return foundVotersPollingStation;
		
	}

	@Override
	public PollingStation findVotersPollingStationByApplicantId(String applicantId) {
		
		Voter foundVoter = findVoterByApplicantId(applicantId);
		
		PollingStation foundVotersPollingStation = pollingStationDao.getPollingStationByCode(foundVoter.getPollingStationInfo().getPollingStationCode());
		
		return foundVotersPollingStation;
		
	}


	


}
