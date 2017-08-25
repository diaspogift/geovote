package com.geovote.domain.context.election;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.context.result.QuestionReponse;

@Entity
public class Candidate implements Serializable{

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String candidateId;
	private String name;
	
	@OneToMany(mappedBy="candidate", cascade=CascadeType.ALL)
	private Set<Candidature> candidatures;
	
	@OneToMany(mappedBy="candidate", cascade=CascadeType.ALL)
	private Set<QuestionReponse> questionReponses;






	public void registerForElection(Candidature candidature) {
		this.candidatures.add(candidature);
	}


	public Candidate() {

	}



	public Candidate(String candidateId, String name, Set<Candidature> candidatures,
			Set<QuestionReponse> questionReponses) {
		this.candidateId = candidateId;
		this.name = name;
		this.candidatures = candidatures;
		this.questionReponses = questionReponses;
	}



	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Candidature> getRegistrations() {
		return candidatures;
	}

	public void setRegistrations(Set<Candidature> registrations) {
		this.candidatures = registrations;
	}



	public Set<Candidature> getCandidatures() {
		return candidatures;
	}



	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}


	public Set<QuestionReponse> getQuestionReponses() {
		return questionReponses;
	}

	public void setQuestionReponses(Set<QuestionReponse> questionReponses) {
		this.questionReponses = questionReponses;
	}
}
