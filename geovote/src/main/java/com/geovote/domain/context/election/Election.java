package com.geovote.domain.context.election;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.context.result.QuestionReponse;
import com.geovote.domain.context.helper.ElectionInfo;

@Entity
@XmlRootElement
public class Election implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String code;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ELECTION_FK_ID")
	private Set<Theme> themes;
	
	@OneToMany(mappedBy="election", cascade = CascadeType.ALL)
	private Set<Candidature> candidatures;
	
	@OneToMany(mappedBy="election", cascade = CascadeType.ALL)
	private Set<Vote> votes;

	@OneToMany(mappedBy="election", cascade=CascadeType.ALL)
	private Set<QuestionReponse> questionReponses;
	
	
	
	
	//business
	public void addVote(Vote vote) {

		this.votes.add(vote);
	}
	public void addCandidate(Candidature candidature) {
		this.candidatures.add(candidature);
	}


	public void addTheme(Theme theme) {
		this.themes.add(theme);
	}



	public ElectionInfo retrieveElectionInfo() {
		return new ElectionInfo(this.code, this.name);
	}

	
	public Election() {

	}


	public Election(String code, String name, Date date, Set<Theme> themes,
			Set<Candidature> candidatures, Set<Vote> votes) {
		super();
		this.code = code;
		this.name = name;
		this.date = date;
		this.themes = themes;
		this.candidatures = candidatures;
		this.votes = votes;
	}




	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Set<Theme> getThemes() {
		return themes;
	}


	public void setThemes(Set<Theme> themes) {
		this.themes = themes;
	}


	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public Set<Candidature> getCandidatures() {
		return candidatures;
	}


	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}


	public Set<Vote> getVotes() {
		return votes;
	}


	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	public Set<QuestionReponse> getQuestionReponses() {
		return questionReponses;
	}

	public void setQuestionReponses(Set<QuestionReponse> questionReponses) {
		this.questionReponses = questionReponses;
	}


}
