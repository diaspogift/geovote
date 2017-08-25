package com.geovote.services.impl;

import com.geovote.data.intf.ExitPollDao;
import com.geovote.domain.context.election.Election;
import com.geovote.domain.context.election.Question;
import com.geovote.domain.context.result.QuestionReponse;
import com.geovote.rest.representation.*;
import com.geovote.services.intf.ElectionService;
import com.geovote.services.intf.ExitPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by elberto on 3/15/17.
 */

@Service
@Transactional
public class ExitPollServiceImpl implements ExitPollService {

    @Autowired
    private ExitPollDao exitPollDao;
    @Autowired
    private ElectionService electionService;
    @Autowired
    private ExitPollService exitPollService;


    @Override
    public ExitPollQuizCollectionRepresentation retriveElectionPoll(String electionCode) {
        return exitPollDao.getElectionPoll(electionCode);
    }



    @Override
    public void registerNewPoll(String electionCode,   List<QuizReponseRepresentation> allQuizResQuizReponseRepresentations) {


        Election foundElection = electionService.findElectionByCode(electionCode);
        Set<QuestionReponse> allQuestionReponses = foundElection.getQuestionReponses();

        for(QuizReponseRepresentation nextQuizReponseRepresentation : allQuizResQuizReponseRepresentations){

            String candateCode = nextQuizReponseRepresentation.getCandidateCode();
            String questionCode = nextQuizReponseRepresentation.getQuestionCode();

            for(QuestionReponse nextQuestionReponse : allQuestionReponses){

                if(nextQuestionReponse.getCandidate().getCandidateId().equals(candateCode) && nextQuestionReponse.getQuestion().getCode().equals(questionCode)){

                    System.out.println("in if electionCode ====   "+electionCode+"  candateCode  = "+candateCode+" question code = "+questionCode);

                    System.out.println("foundElection.getQuestionReponses() size before remove "+foundElection.getQuestionReponses().size());


                    //foundElection.getQuestionReponses().remove(nextQuestionReponse);

                    System.out.println("foundElection.getQuestionReponses() size after remove"+foundElection.getQuestionReponses().size());


                    nextQuestionReponse.updateCandidteFavorableOpinionCount();

                    //foundElection.getQuestionReponses().add(nextQuestionReponse);

                }

            }

        }


    }

    @Override
    public List<QuestionReponseRepresentation> retrieveAllQuestionResponses(String electionCode) {
        return exitPollDao.retrieveAllQuestionResponses(electionCode);
    }
}
