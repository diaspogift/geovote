package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candidature")
public class CandidatureRepresentation {

	private String candidateRegistrationId;
	private String candidateSignature;
	private String registrationDate;

	public CandidatureRepresentation() {
	}

	public CandidatureRepresentation(String candidateRegistrationId, String candidateSignature,
			String registrationDate) {
		this.candidateRegistrationId = candidateRegistrationId;
		this.candidateSignature = candidateSignature;
		this.registrationDate = registrationDate;
	}



	public String getCandidateRegistrationId() {
		return candidateRegistrationId;
	}

	public void setCandidateRegistrationId(String candidateRegistrationId) {
		this.candidateRegistrationId = candidateRegistrationId;
	}

	public String getCandidateSignature() {
		return candidateSignature;
	}

	public void setCandidateSignature(String candidateSignature) {
		this.candidateSignature = candidateSignature;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

}
