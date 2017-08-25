package com.geovote.rest.representation;

import com.geovote.domain.context.election.Question;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by elberto on 3/13/17.
 */

@XmlRootElement(name="questions")
public class ElectionThemesQuestionsRepresentation {

    private List<Question> questions;




    public ElectionThemesQuestionsRepresentation(List<Question> electionThemesQuestions) {

        this.questions = electionThemesQuestions;
    }

    @XmlElement(name = "question")
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
