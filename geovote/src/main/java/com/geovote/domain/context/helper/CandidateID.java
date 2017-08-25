package com.geovote.domain.context.helper;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CandidateID implements Serializable {
	

	private String canditateId;
	private String candidateName;
	
	
	public CandidateID(String candidateId, String name) {
		this.canditateId = candidateId;
		this.candidateName = name;
		
	}


	public String getCanditateId() {
		return canditateId;
	}


	public void setCanditateId(String canditateId) {
		this.canditateId = canditateId;
	}


	public String getCandidateName() {
		return candidateName;
	}


	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	
	

}
