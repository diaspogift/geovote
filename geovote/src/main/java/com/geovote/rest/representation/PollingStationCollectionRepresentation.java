package com.geovote.rest.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.context.administrative.PollingStation;

@XmlRootElement(name = "pollingStations")
public class PollingStationCollectionRepresentation {

	private List<PollingStation> pollingStations;

	public PollingStationCollectionRepresentation() {
	}

	public PollingStationCollectionRepresentation(List<PollingStation> pollingStations) {
		this.pollingStations = pollingStations;
	}

	public PollingStationCollectionRepresentation(Set<PollingStation> pollingStations) {
		this.pollingStations = new ArrayList<PollingStation>(pollingStations);
	}

	public List<PollingStation> getPollingStations() {
		return pollingStations;
	}

	public void setPollingStations(List<PollingStation> pollingStations) {
		this.pollingStations = pollingStations;
	}

}
