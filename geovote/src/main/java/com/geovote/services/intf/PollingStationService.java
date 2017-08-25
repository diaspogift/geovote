package com.geovote.services.intf;

import java.util.List;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;

public interface PollingStationService {
	
	public void createNewPollingStation(PollingStation newPollingStation);
	public void deleteExistingPollingStation(PollingStation pollingStationToDelete);
	public List<PollingStation> retrieveAllPollingStations();
	public void updatePollingStation(PollingStation pollingStationToUpdate);
	public PollingStation findPollingStationByCode(String code);
	public List<Voter> findPollingStationsVoters(String code);
	public Long countPollingStationsVoters(String code);

}
