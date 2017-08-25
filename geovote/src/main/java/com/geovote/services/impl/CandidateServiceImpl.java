package com.geovote.services.impl;

import javax.transaction.Transactional;

import com.geovote.services.intf.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.domain.context.election.Candidate;
import com.geovote.data.intf.CandidateDao;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	
	@Autowired
	private CandidateDao dao;
	


	@Override
	public Candidate findCadidateByCode(String candidateRegistrationId) {
		return dao.findCandidateByCode(candidateRegistrationId);

	}



	@Override
	public void createCandidatesThemePercentages(String code, String candidateId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewCandidate(Candidate can1) {
		dao.create(can1);
	}


/*
	@Override
	public void createCandidatesThemePercentages(String code, String candidateId) {
		dao.createCandidatesThemePercentages(code, candidateId);
		
	}*/

}
