package com.geovote.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.geovote.services.intf.PollingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;
import com.geovote.data.intf.PollingStationDao;


@Service
@Transactional
public class PollingStationServiceImpl implements PollingStationService {

	@Autowired
	PollingStationDao dao;

	@Override
	public void createNewPollingStation(PollingStation newPollingStation) {
		dao.create(newPollingStation);
	}

	@Override
	public void deleteExistingPollingStation(PollingStation pollingStationToDelete) {
		dao.delete(pollingStationToDelete);
	}

	@Override
	public List<PollingStation> retrieveAllPollingStations() {
		return dao.allPollingStations();
	}

	@Override
	public void updatePollingStation(PollingStation pollingStationToUpdate) {

		dao.update(pollingStationToUpdate);
	}

	@Override
	public PollingStation findPollingStationByCode(String code) {
		
		return dao.getPollingStationByCode(code);
	}

	@Override
	public List<Voter> findPollingStationsVoters(String code) {

		return dao.getPollingStationsVoters(code);
	}

	@Override
	public Long countPollingStationsVoters(String code) {
		
		 return dao.countPollingStationsVoters(code);
	}

}
