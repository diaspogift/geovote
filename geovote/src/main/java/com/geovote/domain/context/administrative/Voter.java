package com.geovote.domain.context.administrative;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.geovote.domain.context.election.Vote;
import com.geovote.domain.context.helper.ConstituencyInfo;
import com.geovote.domain.context.helper.DistrictInfo;
import com.geovote.domain.context.helper.ParishInfo;
import com.geovote.domain.context.helper.PollingStationInfo;
import com.geovote.domain.context.helper.SubCountyInfo;

@Entity
@XmlRootElement
public class Voter implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String applicantId;
	@Column(unique = true, nullable = false)
	private String voterNumber;
	private String surname;
	private String othernames;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	private String sex;
	private String village;
	private String picturePath;
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	@Embedded
	private DistrictInfo districtInfo;
	@Embedded
	private ConstituencyInfo constituencyInfo;
	@Embedded
	private ParishInfo parishInfo;
	@Embedded
	private PollingStationInfo pollingStationInfo;
	@Embedded
	private SubCountyInfo subCountyInfo;
	@OneToMany(mappedBy="voter", cascade= CascadeType.ALL)
	//@JsonManagedReference
	private Set<Vote> votes;
	
	
	
	


	public Voter() {
	}

	public Voter(String applicantId, String voterNumber, String surname, String othernames, Date dob,
			String sex, String village, String picturePath, Date expiryDate, DistrictInfo districtInfo,
			ConstituencyInfo constituencyInfo, ParishInfo parishInfo, PollingStationInfo pollingStationInfo,
			SubCountyInfo subCountyInfo, Set<Vote> votes) {
		super();
		this.applicantId = applicantId;
		this.voterNumber = voterNumber;
		this.surname = surname;
		this.othernames = othernames;
		this.dob = dob;
		this.sex = sex;
		this.village = village;
		this.picturePath = picturePath;
		this.expiryDate = expiryDate;
		this.districtInfo = districtInfo;
		this.constituencyInfo = constituencyInfo;
		this.parishInfo = parishInfo;
		this.pollingStationInfo = pollingStationInfo;
		this.subCountyInfo = subCountyInfo;
		this.votes = votes;
	}



	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getVoterNumber() {
		return voterNumber;
	}

	public void setVoterNumber(String voterNumber) {
		this.voterNumber = voterNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOthernames() {
		return othernames;
	}

	public void setOthernames(String othernames) {
		this.othernames = othernames;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public DistrictInfo getDistrictInfo() {
		return districtInfo;
	}

	public void setDistrictInfo(DistrictInfo districtInfo) {
		this.districtInfo = districtInfo;
	}

	public ConstituencyInfo getConstituencyInfo() {
		return constituencyInfo;
	}

	public void setConstituencyInfo(ConstituencyInfo constituencyInfo) {
		this.constituencyInfo = constituencyInfo;
	}

	public ParishInfo getParishInfo() {
		return parishInfo;
	}

	public void setParishInfo(ParishInfo parishInfo) {
		this.parishInfo = parishInfo;
	}

	public PollingStationInfo getPollingStationInfo() {
		return pollingStationInfo;
	}

	public void setPollingStationInfo(PollingStationInfo pollingStationInfo) {
		this.pollingStationInfo = pollingStationInfo;
	}

	public SubCountyInfo getSubCountyInfo() {
		return subCountyInfo;
	}

	public void setSubCountyInfo(SubCountyInfo subCountyInfo) {
		this.subCountyInfo = subCountyInfo;
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Voter{" +
				"id=" + id +
				", applicantId='" + applicantId + '\'' +
				", voterNumber='" + voterNumber + '\'' +
				", surname='" + surname + '\'' +
				", othernames='" + othernames + '\'' +
				", dob=" + dob +
				", sex='" + sex + '\'' +
				", village='" + village + '\'' +
				", picturePath='" + picturePath + '\'' +
				", expiryDate=" + expiryDate +
				", districtInfo=" + districtInfo +
				", constituencyInfo=" + constituencyInfo +
				", parishInfo=" + parishInfo +
				", pollingStationInfo=" + pollingStationInfo +
				", subCountyInfo=" + subCountyInfo +
				'}';
	}
}
