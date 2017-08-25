package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by elberto on 3/16/17.
 */
@XmlRootElement
public class QuizReponseRepresentation {

    private String questionCode;
    private String candidateCode;

    public QuizReponseRepresentation() {
    }

    public QuizReponseRepresentation(String questionCode, String candidateCode) {
        this.questionCode = questionCode;
        this.candidateCode = candidateCode;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getCandidateCode() {
        return candidateCode;
    }

    public void setCandidateCode(String candidateCode) {
        this.candidateCode = candidateCode;
    }
}
