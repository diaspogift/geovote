package com.geovote.domain.context.helper;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ElectionInfo implements Serializable {

	private String electionCode;
	private String electionName;

	public ElectionInfo() {
	}

	public ElectionInfo(String electionCode, String electionName) {
		this.electionCode = electionCode;
		this.electionName = electionName;
	}

	public String getElectionCode() {
		return electionCode;
	}

	public void setElectionCode(String electionCode) {
		this.electionCode = electionCode;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

}
