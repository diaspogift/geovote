package com.geovote.domain.context.election;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Candidature implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Id
	@ManyToOne
	@JoinColumn(name="election_id")
	private Election election;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registration_date")
	private Date date;
	private String signature;
	
	public Candidature(){
		
	}



	public Candidature(Candidate candidate, Election election, Date date, String signature) {
		super();
		this.candidate = candidate;
		this.election = election;
		this.date = date;
		this.signature = signature;
	}



	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public String getSignature() {
		return signature;
	}



	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Candidature)) return false;

		Candidature that = (Candidature) o;

		if (!getCandidate().equals(that.getCandidate())) return false;
		if (!getElection().equals(that.getElection())) return false;
		if (!getDate().equals(that.getDate())) return false;
		return getSignature().equals(that.getSignature());
	}

	@Override
	public int hashCode() {
		int result = getCandidate().hashCode();
		result = 31 * result + getElection().hashCode();
		result = 31 * result + getDate().hashCode();
		result = 31 * result + getSignature().hashCode();
		return result;
	}


}
