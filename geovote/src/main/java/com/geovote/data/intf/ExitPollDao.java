package com.geovote.data.intf;

import com.geovote.rest.representation.ExitPollQuizCollectionRepresentation;
import com.geovote.rest.representation.QuestionReponseRepresentation;

import java.util.List;

/**
 * Created by elberto on 3/15/17.
 */
public interface ExitPollDao {


    ExitPollQuizCollectionRepresentation getElectionPoll(String electionCode);

    List<QuestionReponseRepresentation> retrieveAllQuestionResponses(String electionCode);
}
