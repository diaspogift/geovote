package com.geovote.controllers.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;
import com.geovote.rest.representation.VotersCollectionRepresentation;
import com.geovote.services.intf.VoterService;

@RestController
public class VoterController {

	@Autowired
	VoterService voterService;
	



	@RequestMapping(value = "/voters", method = RequestMethod.GET)
	public VotersCollectionRepresentation allVotersUseCase() {

		List<Voter> allVoters = voterService.retrieveAllVoters();

		return new VotersCollectionRepresentation(allVoters);
	}

	@RequestMapping(value = "/voter/{id}", method = RequestMethod.GET)
	public Voter findVoterById(@PathVariable String id,
			@RequestParam(required = false, defaultValue = "voterId") String idType) {
		
		
		

		if (idType.equals("applicantId")) {

			return voterService.findVoterByApplicantId(id);

		} else if (idType.equals("voterId")) {


			return voterService.findVoterByVoterId(id);

		} else {

			return new Voter();
		}

	}

	@RequestMapping(value = "/voter/{id}/pollingstation", method = RequestMethod.GET)
	public PollingStation findVoterPollingStation(@PathVariable String id,
			@RequestParam(required = false, defaultValue = "voterId") String idType) {

		if (idType.equals("applicantId")) {

			return voterService.findVotersPollingStationByApplicantId(id);

		} else if (idType.equals("voterId")) {

			return voterService.findVotersPollingStationByVoterId(id);

		} else {
			return new PollingStation();
		}

	}
	
	

}