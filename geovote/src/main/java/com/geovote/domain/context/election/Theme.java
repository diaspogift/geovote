package com.geovote.domain.context.election;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.geovote.domain.context.helper.ElectionInfo;
import com.geovote.domain.context.helper.ThemeInfo;

@Entity
@XmlRootElement
public class Theme implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String code;
	private String name;

	@Embedded
	ElectionInfo electionInfo;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "THEME_FK_ID")
    @JsonManagedReference
    private Set<Question> questions;


    public void addNewQuestion(Question newQuestion) {
        this.questions.add(newQuestion);
    }



    public ThemeInfo retrieveThemeInfo() {

        return  new ThemeInfo(this.code,this.name);
    }



	public Theme() {

	}

    public Theme(String code, String name, ElectionInfo electionInfo, Set<Question> questions) {
        this.code = code;
        this.name = name;
        this.electionInfo = electionInfo;
        this.questions = questions;
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

	public Long getId() {
		return id;
	}

	public ElectionInfo getElectionInfo() {
		return electionInfo;
	}

	public void setElectionInfo(ElectionInfo electionInfo) {
		this.electionInfo = electionInfo;
	}

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}




}
