package com.geovote.domain.context.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PollingStationInfo implements Serializable {

	@Column(nullable=false)
	private String pollingStationCode;
	@Column(nullable=false)
	private String pollingStationName;

	public PollingStationInfo() {
	}

	public PollingStationInfo(String pollingStationCode, String pollingStationName) {
		super();
		this.pollingStationCode = pollingStationCode;
		this.pollingStationName = pollingStationName;
	}

	public String getPollingStationCode() {
		return pollingStationCode;
	}

	public void setPollingStationCode(String pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

	public String getPollingStationName() {
		return pollingStationName;
	}

	public void setPollingStationName(String pollingStationName) {
		this.pollingStationName = pollingStationName;
	}

}
