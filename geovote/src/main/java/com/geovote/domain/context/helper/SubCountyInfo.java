package com.geovote.domain.context.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubCountyInfo implements Serializable {

	@Column(nullable=false)
	private String subCountyCode;
	@Column(nullable=false)
	private String subCountyName;

	public SubCountyInfo() {
	}

	public SubCountyInfo(String subCountyCode, String subCountyName) {
		super();
		this.subCountyCode = subCountyCode;
		this.subCountyName = subCountyName;
	}

	public String getSubCountyCode() {
		return subCountyCode;
	}

	public void setSubCountyCode(String subCountyCode) {
		this.subCountyCode = subCountyCode;
	}

	public String getSubCountyName() {
		return subCountyName;
	}

	public void setSubCountyName(String subCountyName) {
		this.subCountyName = subCountyName;
	}

}
