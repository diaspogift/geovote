package com.geovote.rest.representation;

import java.util.List;

/**
 * Created by elberto on 3/15/17.
 */
public class CandidateQuestionReponseRepresentation1 {

    private String code;
    private String title;
    private String themeCode;
    private String themeName;

    private List<CandidateQuestionReponseRepresentation> propositions;

    public CandidateQuestionReponseRepresentation1() {
    }

    public CandidateQuestionReponseRepresentation1(String code, String title, String themeCode, String themeName, List<CandidateQuestionReponseRepresentation> propositions) {
        this.code = code;
        this.title = title;
        this.themeCode = themeCode;
        this.themeName = themeName;
        this.propositions = propositions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public List<CandidateQuestionReponseRepresentation> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<CandidateQuestionReponseRepresentation> propositions) {
        this.propositions = propositions;
    }
}
