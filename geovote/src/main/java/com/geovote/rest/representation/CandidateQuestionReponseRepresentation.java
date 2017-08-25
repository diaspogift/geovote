package com.geovote.rest.representation;

import com.geovote.domain.context.result.QuestionReponse;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by elberto on 3/15/17.
 */
@XmlRootElement(name = "proposition")
public class CandidateQuestionReponseRepresentation {

    private String candidateId;
    private String opinion;


    public CandidateQuestionReponseRepresentation() {
    }

    public CandidateQuestionReponseRepresentation(String candidateId, String opinion) {
        this.candidateId = candidateId;
        this.opinion = opinion;
    }

    public CandidateQuestionReponseRepresentation(QuestionReponse nextQuestionReponse) {

        this.candidateId = nextQuestionReponse.getCandidate().getCandidateId();
        this.opinion = nextQuestionReponse.getCandidateOpinion();
    }


    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
