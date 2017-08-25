package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;

public interface PollingStationDao {
	
	public void create(PollingStation pollingStation);
	public void delete(PollingStation pollingStation);
	public List<PollingStation> allPollingStations();
	public PollingStation getPollingStationByCode(String pollingStationCode);
	public void update(PollingStation pollingStationToUpdate);
	public List<Voter> getPollingStationsVoters(String code);
	public Long countPollingStationsVoters(String code);

}
