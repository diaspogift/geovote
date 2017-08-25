package com.geovote.domain.context.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ConstituencyInfo implements Serializable {

	@Column(nullable=false)
	private String constituencyCode;
	@Column(nullable=false)
	private String constituencyName;

	public ConstituencyInfo() {
	}
	
	

	public ConstituencyInfo(String constituencyCode, String constituencyName) {
		super();
		this.constituencyCode = constituencyCode;
		this.constituencyName = constituencyName;
	}



	public String getConstituencyCode() {
		return constituencyCode;
	}

	public void setConstituencyCode(String constituencyCode) {
		this.constituencyCode = constituencyCode;
	}

	public String getConstituencyName() {
		return constituencyName;
	}

	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}

}
