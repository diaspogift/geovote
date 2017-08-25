package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by elberto on 3/16/17.
 */

@XmlRootElement(name = "questionreponses")
public class QuestionReponseCollectionRepresentation {

    private List<QuestionReponseRepresentation> questionreponses;

    public QuestionReponseCollectionRepresentation() {
    }

    public QuestionReponseCollectionRepresentation(List<QuestionReponseRepresentation> questionreponses) {
        this.questionreponses = questionreponses;
    }

    public List<QuestionReponseRepresentation> getQuestionreponses() {
        return questionreponses;
    }

    public void setQuestionreponses(List<QuestionReponseRepresentation> questionreponses) {
        this.questionreponses = questionreponses;
    }
}
