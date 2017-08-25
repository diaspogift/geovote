package com.geovote.domain.context.result;

import com.geovote.domain.context.election.Candidate;
import com.geovote.domain.context.election.Election;
import com.geovote.domain.context.election.Question;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by elberto on 3/13/17.
 */
@Entity
@XmlRootElement
public class QuestionReponse implements Serializable{


    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Id
    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;

    private Double weight;
    private Long favorableOpinionCount;
    private String candidateOpinion;


    public void updateCandidteFavorableOpinionCount() {

        this.favorableOpinionCount = this.favorableOpinionCount+1;
    }

    public QuestionReponse() {
    }


    public QuestionReponse(Candidate candidate, Question question, Election election, Double weight, Long favorableOpinionCount, String candidateOpinion) {
        this.candidate = candidate;
        this.question = question;
        this.election = election;
        this.weight = weight;
        this.favorableOpinionCount = favorableOpinionCount;
        this.candidateOpinion = candidateOpinion;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Long getFavorableOpinionCount() {
        return favorableOpinionCount;
    }

    public void setFavorableOpinionCount(Long favorableOpinionCount) {
        this.favorableOpinionCount = favorableOpinionCount;
    }

    public String getCandidateOpinion() {
        return candidateOpinion;
    }

    public void setCandidateOpinion(String candidateOpinion) {
        this.candidateOpinion = candidateOpinion;
    }


}
