package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vote")
public class VoteRepresentation {

	private String electionCode;
	private String voterId;
	private String pollingStationCode;
	private String date;
	private String signature;
	
	

	public VoteRepresentation() {

	}

	public VoteRepresentation(String electionCode, String voterId, String pollingStationCode, String date, String signature) {
		this.electionCode = electionCode;
		this.voterId = voterId;
		this.pollingStationCode = pollingStationCode;
		this.date = date;
		this.signature = signature;
	}

	public String getElectionCode() {
		return electionCode;
	}

	public void setElectionCode(String electionCode) {
		this.electionCode = electionCode;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getPollingStationCode() {
		return pollingStationCode;
	}

	public void setPollingStationCode(String pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}


	@Override
	public String toString() {
		return "VoteRepresentation{" +
				"electionCode='" + electionCode + '\'' +
				", voterId='" + voterId + '\'' +
				", pollingStationCode='" + pollingStationCode + '\'' +
				", date='" + date + '\'' +
				", signature='" + signature + '\'' +
				'}';
	}
}
