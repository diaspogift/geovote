package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by elberto on 3/16/17.
 */

@XmlRootElement
public class CandidatesQuestionsWeightRepresentation {

    private String questionCode;

    private List<CandidateCofficientRepresentation> CandidateCofficientRepresentation;

    public CandidatesQuestionsWeightRepresentation() {
    }

    public CandidatesQuestionsWeightRepresentation(String questionCode, List<com.geovote.rest.representation.CandidateCofficientRepresentation> candidateCofficientRepresentation) {
        this.questionCode = questionCode;
        CandidateCofficientRepresentation = candidateCofficientRepresentation;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public List<com.geovote.rest.representation.CandidateCofficientRepresentation> getCandidateCofficientRepresentation() {
        return CandidateCofficientRepresentation;
    }

    public void setCandidateCofficientRepresentation(List<com.geovote.rest.representation.CandidateCofficientRepresentation> candidateCofficientRepresentation) {
        CandidateCofficientRepresentation = candidateCofficientRepresentation;
    }
}
