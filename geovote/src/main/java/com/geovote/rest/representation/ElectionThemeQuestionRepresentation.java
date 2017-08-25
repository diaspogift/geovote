package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by elberto on 3/13/17.
 */
@XmlRootElement
public class ElectionThemeQuestionRepresentation {

    private String code;
    private String title;


    public ElectionThemeQuestionRepresentation() {
    }

    public ElectionThemeQuestionRepresentation(String code, String title) {
        this.code = code;
        this.title = title;
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

    @Override
    public String toString() {
        return "ElectionThemeQuestionRepresentation{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
