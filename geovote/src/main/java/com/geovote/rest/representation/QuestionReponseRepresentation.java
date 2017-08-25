package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by elberto on 3/16/17.
 */
@XmlRootElement(name = "questionreponse")
public class QuestionReponseRepresentation {

    private String questionCode;
    private String candidateCode;
    private Double weight;


    public QuestionReponseRepresentation() {
    }

    public QuestionReponseRepresentation(String questionCode, String candidateCode, Double weight) {
        this.questionCode = questionCode;
        this.candidateCode = candidateCode;
        this.weight = weight;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questioncode) {
        this.questionCode = questioncode;
    }

    public String getCandidateCode() {
        return candidateCode;
    }

    public void setCandidateCode(String candidateCode) {
        this.candidateCode = candidateCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
