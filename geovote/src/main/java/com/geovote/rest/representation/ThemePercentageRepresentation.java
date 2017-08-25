package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "themepercentage")
public class ThemePercentageRepresentation {

	private String electionCode;
	private String candidateId;
	private String themeId;
	private Double percentage;

	
	public ThemePercentageRepresentation() {
	}



	public ThemePercentageRepresentation(String electionCode, String candidateId, String themeId, Double percentage) {
		super();
		this.electionCode = electionCode;
		this.candidateId = candidateId;
		this.themeId = themeId;
		this.percentage = percentage;
	}



	public String getElectionCode() {
		return electionCode;
	}


	public void setElectionCode(String electionCode) {
		this.electionCode = electionCode;
	}


	public String getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}


	public String getThemeId() {
		return themeId;
	}



	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}



	public Double getPercentage() {
		return percentage;
	}


	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	

}
