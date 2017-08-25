package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by elberto on 3/14/17.
 */

@XmlRootElement
public class ElectionNameCodeRepresentation {

    private  String code;
    private  String name;



    public ElectionNameCodeRepresentation() {
    }

    public ElectionNameCodeRepresentation(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
