package com.geovote.data.impl;

import com.geovote.data.intf.ExitPollDao;
import com.geovote.domain.context.election.Election;
import com.geovote.domain.context.election.Question;
import com.geovote.domain.context.result.QuestionReponse;
import com.geovote.rest.representation.ExitPollQuizCollectionRepresentation;
import com.geovote.rest.representation.QuestionReponseRepresentation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by elberto on 3/15/17.
 */
@Repository
public class ExitPollDaoJpaImpl implements ExitPollDao {


    @PersistenceContext
    private EntityManager em;


    @Override
    public ExitPollQuizCollectionRepresentation getElectionPoll(String electionCode) {

        Election foundElection =  em.createQuery("select election from Election as election where election.code=:electionCode",
                Election.class)
                .setParameter("electionCode",electionCode)
                .getSingleResult();

        Set<QuestionReponse> allQuestionReponses = foundElection.getQuestionReponses();
        Set<Question> allQuestions = new HashSet<Question>();




        for(QuestionReponse nextQuestionReponse : allQuestionReponses){
            allQuestions.add(nextQuestionReponse.getQuestion());
        }




        return  new ExitPollQuizCollectionRepresentation(allQuestions);

    }

    @Override
    public List<QuestionReponseRepresentation> retrieveAllQuestionResponses(String electionCode) {



        List<QuestionReponse> allElectionQuestionReponses = em.createQuery("select questionReponse from QuestionReponse as questionReponse")
                                                                .getResultList();

        List<QuestionReponseRepresentation> questionReponseRepresentations = new ArrayList<QuestionReponseRepresentation>();


        for(QuestionReponse nextQuestionReponse : allElectionQuestionReponses){

            questionReponseRepresentations.add(new QuestionReponseRepresentation(nextQuestionReponse.getQuestion().getCode(), nextQuestionReponse.getCandidate().getCandidateId(),
                    nextQuestionReponse.getWeight()));
        }


            return questionReponseRepresentations;

    }
}
