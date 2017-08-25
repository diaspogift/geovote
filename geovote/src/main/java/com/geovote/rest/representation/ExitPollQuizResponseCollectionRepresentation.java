package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by elberto on 3/16/17.
 */
@XmlRootElement
public class ExitPollQuizResponseCollectionRepresentation {

    private String electionCode;
    private List<QuizReponseRepresentation> choices;


    public ExitPollQuizResponseCollectionRepresentation() {
    }

    public ExitPollQuizResponseCollectionRepresentation(String electionCode, List<QuizReponseRepresentation> choices) {
        this.electionCode = electionCode;
        this.choices = choices;
    }

    public String getElectionCode() {
        return electionCode;
    }

    public void setElectionCode(String electionCode) {
        this.electionCode = electionCode;
    }

    public List<QuizReponseRepresentation> getChoices() {
        return choices;
    }

    public void setChoices(List<QuizReponseRepresentation> choices) {
        this.choices = choices;
    }
}
