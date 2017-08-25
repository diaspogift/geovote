package com.geovote.controllers.restcontrollers;

import com.geovote.rest.representation.*;
import com.geovote.services.intf.ElectionService;
import com.geovote.services.intf.ExitPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by elberto on 3/15/17.
 */

@RestController
public class ExitPollController {

    @Autowired
    private ElectionService electionService;
    @Autowired
    private ExitPollService exitPollService;


    @RequestMapping(value = "/election/{code}/poll", method = RequestMethod.GET)
    public ExitPollQuizCollectionRepresentation retriveElectionPoll(@PathVariable String code){

        return exitPollService.retriveElectionPoll(code);
    }



    @RequestMapping(value = "/election/{code}/poll", method = RequestMethod.POST)
    public void registerNewPoll(@RequestBody ExitPollQuizResponseCollectionRepresentation exitPollQuizResponseCollectionRepresentation){


        String electionCode = exitPollQuizResponseCollectionRepresentation.getElectionCode();
        List<QuizReponseRepresentation> quizReponseRepresentations = exitPollQuizResponseCollectionRepresentation.getChoices();

        System.out.println("electionCode ====   "+electionCode+"  quizReponseRepresentations size = "+quizReponseRepresentations.size());
        System.out.println("electionCode ====   "+electionCode+"  quizReponseRepresentations size = "+quizReponseRepresentations.size());
        System.out.println("electionCode ====   "+electionCode+"  quizReponseRepresentations size = "+quizReponseRepresentations.size());
        System.out.println("electionCode ====   "+electionCode+"  quizReponseRepresentations size = "+quizReponseRepresentations.size());


        exitPollService.registerNewPoll(electionCode, quizReponseRepresentations);

    }

    @RequestMapping(value = "/election/{electionCode}/questionresponses", method = RequestMethod.GET)
    public QuestionReponseCollectionRepresentation retrieveAllQuestionResponses(@PathVariable  String electionCode){


        List<QuestionReponseRepresentation> questionReponseRepresentations = exitPollService.retrieveAllQuestionResponses(electionCode);


        return new QuestionReponseCollectionRepresentation(questionReponseRepresentations);


    }

}
