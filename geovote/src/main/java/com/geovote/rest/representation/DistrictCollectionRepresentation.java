package com.geovote.rest.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.context.administrative.District;

@XmlRootElement(name = "districts")
public class DistrictCollectionRepresentation {

	private List<District> allDistricts;

	public DistrictCollectionRepresentation() {
	}

	public DistrictCollectionRepresentation(List<District> allDistricts) {
		this.allDistricts = allDistricts;
	}

	@XmlElement(name = "district")
	public List<District> getAllDistricts() {
		return allDistricts;
	}

	public void setAllDistricts(List<District> allDistricts) {
		this.allDistricts = allDistricts;
	}

}
