package com.geovote.domain.context.administrative;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.geovote.domain.context.helper.ConstituencyInfo;

@Entity
public class Constituency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique=true, nullable=false)
	private String code;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "CONSTITUENCY_FK_ID")
	private Set<SubCounty> subCounties;
	
	
	
	
	
	public ConstituencyInfo retrieveBasicInfo(){
		
		return new ConstituencyInfo(this.code, this.name);
	}
	
	
	public Constituency() {}


	public Constituency(String code, String name, Set<SubCounty> subCounties) {
		this.code = code;
		this.name = name;
		this.subCounties = new HashSet<SubCounty>(subCounties);
	}

	public Constituency(String code, String name) {

		this.code = code;
		this.name = name;
		this.subCounties = new HashSet<SubCounty>();
	}

	
	
	public Long getId() {
		return id;
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

	public Set<SubCounty> getSubCounties() {
		return subCounties;
	}

	public void setSubCounties(Set<SubCounty> subCounties) {
		this.subCounties = subCounties;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constituency other = (Constituency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}


}
