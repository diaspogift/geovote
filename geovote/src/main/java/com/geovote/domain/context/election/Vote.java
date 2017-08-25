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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geovote.domain.context.administrative.Voter;

@Entity
@XmlRootElement
public class Vote implements Serializable {


	@Id
	@ManyToOne
	@JoinColumn(name = "voter_id")
	//@JsonBackReference
	private Voter voter;

	@Id
	@ManyToOne
	@JoinColumn(name = "election_id")
	private Election election;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vote_date")
	private Date date;

	public Vote() {
	}

	private String signature;

	public Vote(Voter voter, Election election, Date date, String signature) {
		super();
		this.voter = voter;
		this.election = election;
		this.date = date;
		this.signature = signature;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
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

//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (!(o instanceof Vote)) return false;
//
//		Vote vote = (Vote) o;
//
//		if (!getVoter().equals(vote.getVoter())) return false;
//		if (!getElection().equals(vote.getElection())) return false;
//		if (!getDate().equals(vote.getDate())) return false;
//		return getSignature().equals(vote.getSignature());
//	}
//
//	@Override
//	public int hashCode() {
//		int result = getVoter().hashCode();
//		result = 31 * result + getElection().hashCode();
//		result = 31 * result + getDate().hashCode();
//		result = 31 * result + getSignature().hashCode();
//		return result;
//	}

}
