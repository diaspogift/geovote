package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by elberto on 3/14/17.
 */
@XmlRootElement
public class CandidateCofficientRepresentation {

   private String candidateCode;
   private  String  name;
   private Double weight;

    public CandidateCofficientRepresentation() {
    }

    public CandidateCofficientRepresentation(String candidateCode, String name, Double weight) {
        this.candidateCode = candidateCode;
        this.name = name;
        this.weight = weight;
    }


    public String getCandidateCode() {
        return candidateCode;
    }

    public void setCandidateCode(String candidateCode) {
        this.candidateCode = candidateCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "CandidateCofficientRepresentation{" +
                "candidateCode='" + candidateCode + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
