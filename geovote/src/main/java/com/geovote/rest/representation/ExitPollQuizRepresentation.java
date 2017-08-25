package com.geovote.rest.representation;

import com.geovote.domain.context.election.Question;
import com.geovote.domain.context.result.QuestionReponse;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by elberto on 3/15/17.
 */
@XmlRootElement
public class ExitPollQuizRepresentation {

    private String electionCode;
    private String themeCode;

    private Map<String, HashSet<CandidateQuestionReponseRepresentation>>  candidateQuestionReponseRepresentation;

    public ExitPollQuizRepresentation() {
    }

    public ExitPollQuizRepresentation(QuestionReponse questionReponse) {



        this.candidateQuestionReponseRepresentation = new  HashMap<String, HashSet<CandidateQuestionReponseRepresentation>> ();

        candidateQuestionReponseRepresentation.put(questionReponse.getQuestion().getCode(), null);

        this.electionCode = questionReponse.getElection().retrieveElectionInfo().getElectionCode();
        this.themeCode = questionReponse.getQuestion().getThemeInfo().getThemeCode();

    }

    public ExitPollQuizRepresentation(String electionCode, String themeCode, String questionCode, String candidateId, String opnionTitle) {
        this.electionCode = electionCode;
        this.themeCode = themeCode;

    }

    public String getElectionCode() {
        return electionCode;
    }

    public void setElectionCode(String electionCode) {
        this.electionCode = electionCode;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }



}
