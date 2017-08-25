package com.geovote.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.data.intf.PollingStationDao;
import org.springframework.stereotype.Repository;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;

@Repository
public class PolligStationDoaImpl implements PollingStationDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public void create(PollingStation pollingStation) {

		em.persist(pollingStation);

	}

	@Override
	public void delete(PollingStation pollingStation) {

		em.remove(pollingStation);

	}

	@Override
	public List<PollingStation> allPollingStations() {

		List<PollingStation> allPollingStations = em
				.createQuery("select pollingStation from PollingStation as pollingStation", PollingStation.class)
				.getResultList();

		return allPollingStations;
	}

	@Override
	public PollingStation getPollingStationByCode(String code) {

		PollingStation pollingStation = em.createQuery(
				"select pollingStation from PollingStation as pollingStation where pollingStation.code =:code",
				PollingStation.class).setParameter("code", code).getSingleResult();

		return pollingStation;
	}

	@Override
	public void update(PollingStation pollingStationToUpdate) {

		em.merge(pollingStationToUpdate);
	}

	@Override
	public List<Voter> getPollingStationsVoters(String code) {

		List<Voter> pollingStationsVoters = em
				.createQuery("select voter from Voter as voter where voter.pollingStationInfo.pollingStationCode =:code", Voter.class)
				.setParameter("code", code)
				.getResultList();
		
		return pollingStationsVoters;
	}

	@Override
	public Long countPollingStationsVoters(String code) {
		
		return  em.createQuery("select count(voter.id) from Voter as voter where voter.pollingStationInfo.pollingStationCode =:code", Long.class)
				.setParameter("code", code)
				.getSingleResult();
	
	}

}
