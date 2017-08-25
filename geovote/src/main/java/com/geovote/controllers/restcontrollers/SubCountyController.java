package com.geovote.controllers.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.context.administrative.SubCounty;
import com.geovote.rest.representation.ParishesCollectionRepresentation;
import com.geovote.rest.representation.SubCountyCollectionRepresentation;
import com.geovote.services.intf.SubCountyService;

@RestController
public class SubCountyController {

	@Autowired
	SubCountyService subCountyService;

	@RequestMapping(value = "/subcounties", method = RequestMethod.GET)
	public SubCountyCollectionRepresentation allSubCounties() {

		List<SubCounty> allSubCounties = subCountyService.retrieveAllSubCounties();

		return new SubCountyCollectionRepresentation(allSubCounties);
	}

	@RequestMapping(value = "/subcounty/{code}", method = RequestMethod.GET)
	public SubCounty subCountiesCode(@PathVariable String code) {

		return subCountyService.findSubCountyByCode(code);

	}

	@RequestMapping(value = "/subcounty/{code}/parishes", method = RequestMethod.GET)
	public ParishesCollectionRepresentation subCountiesParishesBySubCountyCode(@PathVariable String code) {

		SubCounty subCounty = subCountyService.findSubCountyByCode(code);

		return new ParishesCollectionRepresentation(subCounty.getParishes());
	}

}
