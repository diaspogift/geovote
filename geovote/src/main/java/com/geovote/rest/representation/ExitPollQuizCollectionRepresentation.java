package com.geovote.rest.representation;

import com.geovote.domain.context.election.Question;
import com.geovote.domain.context.result.QuestionReponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Created by elberto on 3/15/17.
 */

@XmlRootElement(name = "polls")
public class ExitPollQuizCollectionRepresentation {

    List<CandidateQuestionReponseRepresentation1> poll;


    public ExitPollQuizCollectionRepresentation() {
    }


    public ExitPollQuizCollectionRepresentation(Set<Question> allQuestions) {

        poll = new ArrayList<>();

        for(Question nextQuestion : allQuestions){

            CandidateQuestionReponseRepresentation1 candidateQuestionReponseRepresentation1 = new CandidateQuestionReponseRepresentation1(nextQuestion.getCode(),
                    nextQuestion.getTitle(), nextQuestion.getThemeInfo().getThemeCode(), nextQuestion.getThemeInfo().getThemeTitle(),new ArrayList<>());




            Set<QuestionReponse> allQuestionReponses = nextQuestion.getQuestionReponses();



            for(QuestionReponse nextQuestionReponse : allQuestionReponses){

                CandidateQuestionReponseRepresentation candidateQuestionReponseRepresentation = new CandidateQuestionReponseRepresentation(nextQuestionReponse);
                candidateQuestionReponseRepresentation1.getPropositions().add(candidateQuestionReponseRepresentation);
            }


            poll.add(candidateQuestionReponseRepresentation1);

        }
    }


    @XmlElement(name = "poll")
    public List<CandidateQuestionReponseRepresentation1> getPoll() {
        return poll;
    }

    public void setPoll(List<CandidateQuestionReponseRepresentation1> poll) {
        this.poll = poll;
    }
}
