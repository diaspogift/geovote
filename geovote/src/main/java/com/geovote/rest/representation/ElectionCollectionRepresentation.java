package com.geovote.rest.representation;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by elberto on 3/14/17.
 */
@XmlRootElement(name = "elections")
public class ElectionCollectionRepresentation {

    private List<ElectionNameCodeRepresentation> elections;

    public ElectionCollectionRepresentation() {
    }


    public ElectionCollectionRepresentation(List<ElectionNameCodeRepresentation> elections) {
        this.elections = elections;
    }

    public List<ElectionNameCodeRepresentation> getElections() {
        return elections;
    }

    public void setElections(List<ElectionNameCodeRepresentation> elections) {
        this.elections = elections;
    }
}
