package com.geovote.data.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.data.intf.CandidateDao;
import org.springframework.stereotype.Repository;

import com.geovote.domain.context.election.Candidate;


@Repository
public class CandidateDaoJpaImpl implements CandidateDao {

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Candidate can1) {

		em.persist(can1);

	}
	
	
	@Override
	public Candidate findCandidateByCode(String candidateRegistrationId) {
		return em.createQuery("select candidate from Candidate as candidate where candidate.candidateId =:candidateRegistrationId", Candidate.class)
				.setParameter("candidateRegistrationId", candidateRegistrationId)
				.getSingleResult();
	}


	@Override
	public Candidate findElectionCandidateByCode(String code, String candidateRegistrationId) {
		return em.createQuery("select candidate from Candidate as candidate join candidate.candidatures as candidature "
				+ "where candidate.candidateId =:candidateRegistrationId and candidature.election.code=:code", Candidate.class)
				.setParameter("code", code)
				.setParameter("candidateRegistrationId", candidateRegistrationId)
				.getSingleResult();

	}



}
