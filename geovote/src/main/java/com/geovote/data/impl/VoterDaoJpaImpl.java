package com.geovote.data.impl;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.data.intf.VoterDao;
import com.geovote.domain.context.election.Vote;
import org.springframework.stereotype.Repository;

import com.geovote.domain.context.administrative.Voter;

@Repository
public class VoterDaoJpaImpl implements VoterDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Voter newVoter) {
		em.persist(newVoter);
	}

	@Override
	public void update(Voter voterToUpdate) {
		em.merge(voterToUpdate);
	}

	@Override
	public void delete(Voter voterToDelete) {

		em.remove(voterToDelete);
	}

	@Override
	public List<Voter> getAllVoters() {

		List<Voter> allVoters = em.createQuery("select voter from Voter as voter", Voter.class).getResultList();
		return allVoters;
	}

	@Override
	public Voter getVoterById(String id) {


		////TO TROUBLESHOOTTTTTT
		 Voter v = em.createQuery("select voter from Voter as voter where voter.voterNumber=:id",Voter.class)
				 .setParameter("id", id)
				 .getSingleResult();


		return new Voter(v.getApplicantId(), v.getVoterNumber(), v.getSurname(), v.getOthernames(), v.getDob(), v.getSex(), v.getVillage(), v.getPicturePath(),
				v.getExpiryDate(), v.getDistrictInfo(), v.getConstituencyInfo(), v.getParishInfo(), v.getPollingStationInfo(), v.getSubCountyInfo(),
				new HashSet<Vote>());


	}


	@Override
	public List<Voter> getVoterByName(String name) {

		return em.createQuery("select voter from Voter as voter where voter.name=:name",Voter.class)
				 .setParameter("name", name)
				 .getResultList();
	}

	@Override
	public Voter getVoterByApplicantId(String applicantId) {
		
		Voter v =  em.createQuery("select voter from Voter as voter where voter.applicantId=:applicantId",Voter.class)
				 .setParameter("applicantId", applicantId)
				 .getSingleResult();

		return new Voter(v.getApplicantId(), v.getVoterNumber(), v.getSurname(), v.getOthernames(), v.getDob(), v.getSex(), v.getVillage(), v.getPicturePath(),
				v.getExpiryDate(), v.getDistrictInfo(), v.getConstituencyInfo(), v.getParishInfo(), v.getPollingStationInfo(), v.getSubCountyInfo(),
				new HashSet<Vote>());
	}





}
