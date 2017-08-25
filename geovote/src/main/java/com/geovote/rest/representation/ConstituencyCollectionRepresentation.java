package com.geovote.rest.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.context.administrative.Constituency;

@XmlRootElement(name = "constituencies")
public class ConstituencyCollectionRepresentation {

	private List<Constituency> constituencies;

	public ConstituencyCollectionRepresentation() {
	}

	public ConstituencyCollectionRepresentation(List<Constituency> constituencies) {
		this.constituencies = constituencies;
	}

	@XmlElement(name = "constituency")
	public List<Constituency> getConstituencies() {
		return constituencies;
	}

	public void setConstituencies(List<Constituency> constituencies) {
		this.constituencies = constituencies;
	}

}
