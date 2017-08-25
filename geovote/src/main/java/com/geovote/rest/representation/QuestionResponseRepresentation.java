package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

/**
 * Created by elberto on 3/14/17.
 */
@XmlRootElement
public class QuestionResponseRepresentation implements Serializable{

    private List<CandidateCofficientRepresentation> candidatesCofficients;


    public QuestionResponseRepresentation() {

    }


    public List<CandidateCofficientRepresentation> getCandidatesCofficients() {
        return candidatesCofficients;
    }
}
