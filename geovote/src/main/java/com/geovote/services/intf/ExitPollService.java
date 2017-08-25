package com.geovote.services.intf;

import com.geovote.rest.representation.ExitPollQuizCollectionRepresentation;
import com.geovote.rest.representation.ExitPollQuizResponseCollectionRepresentation;
import com.geovote.rest.representation.QuestionReponseRepresentation;
import com.geovote.rest.representation.QuizReponseRepresentation;

import java.util.List;

/**
 * Created by elberto on 3/15/17.
 */
public interface ExitPollService {

    ExitPollQuizCollectionRepresentation retriveElectionPoll(String electionCode);


    void registerNewPoll(String electionCode, List<QuizReponseRepresentation> quizReponseRepresentations);

    List<QuestionReponseRepresentation> retrieveAllQuestionResponses(String electionCode);
}
