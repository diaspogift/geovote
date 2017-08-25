package com.geovote.rest.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.context.administrative.SubCounty;

@XmlRootElement(name = "subcounties")
public class SubCountyCollectionRepresentation {

	private List<SubCounty> subcounties;

	public SubCountyCollectionRepresentation() {
	}

	public SubCountyCollectionRepresentation(List<SubCounty> subcounties) {
		this.subcounties = subcounties;
	}

	@XmlElement(name = "subcounty")
	public List<SubCounty> getSubcounties() {
		return subcounties;
	}

	public void setSubcounties(List<SubCounty> subcounties) {
		this.subcounties = subcounties;
	}

}
