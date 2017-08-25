package com.geovote.domain.context.administrative;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.geovote.domain.context.helper.PollingStationInfo;

import java.io.Serializable;

@Entity
public class PollingStation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String code;
	private String name;
	private Long totalVoters;
	private Long currentVotes;
	private String managerName;
	private String address;
	private Double latitude;
	private Double longitude;







	public PollingStationInfo retrieveBasicInfo() {

		return new PollingStationInfo(this.code, this.name);
	}

	public void updateCurrentVotes() {

		this.currentVotes = this.currentVotes + 1;
	}

	public PollingStation() {
	}

	public PollingStation(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public PollingStation(String code, String name, Double latitude, Double longitude) {
		super();
		this.code = code;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public PollingStation(String code, String name, Long totalVoters, Long currentVotes, String managerName,
			String address, Double latitude, Double longitude) {
		super();
		this.code = code;
		this.name = name;
		this.totalVoters = totalVoters;
		this.currentVotes = currentVotes;
		this.managerName = managerName;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getTotalVoters() {
		return totalVoters;
	}

	public void setTotalVoters(Long totalVoters) {
		this.totalVoters = totalVoters;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCurrentVotes() {
		return currentVotes;
	}

	public void setCurrentVotes(Long currentVotes) {
		this.currentVotes = currentVotes;
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
		PollingStation other = (PollingStation) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}


}
