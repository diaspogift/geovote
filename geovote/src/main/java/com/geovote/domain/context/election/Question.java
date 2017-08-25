package com.geovote.domain.context.election;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geovote.domain.context.result.QuestionReponse;
import com.geovote.domain.context.helper.ElectionInfo;
import com.geovote.domain.context.helper.ThemeInfo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by elberto on 3/13/17.
 */

@Entity
@XmlRootElement
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String title;
    @Embedded
    private ThemeInfo themeInfo;
    @Embedded
    private ElectionInfo electionInfo;

    @OneToMany(mappedBy="question", cascade=CascadeType.ALL)
    @JsonBackReference
    private Set<QuestionReponse> questionReponses;

    public Question() {
    }

    public Question(String code, String title, ThemeInfo themeInfo, ElectionInfo electionInfo, Set<QuestionReponse> questionReponses) {
        this.code = code;
        this.title = title;
        this.themeInfo = themeInfo;
        this.electionInfo = electionInfo;
        this.questionReponses = questionReponses;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ThemeInfo getThemeInfo() {
        return themeInfo;
    }

    public void setThemeInfo(ThemeInfo themeInfo) {
        this.themeInfo = themeInfo;
    }

    public ElectionInfo getElectionInfo() {
        return electionInfo;
    }

    public void setElectionInfo(ElectionInfo electionInfo) {
        this.electionInfo = electionInfo;
    }

    public Set<QuestionReponse> getQuestionReponses() {
        return questionReponses;
    }

    public void setQuestionReponses(Set<QuestionReponse> questionReponses) {
        this.questionReponses = questionReponses;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        return getCode().equals(question.getCode());
    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }


}
