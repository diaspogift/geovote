package com.geovote.controllers.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.context.administrative.District;
import com.geovote.rest.representation.DistrictCollectionRepresentation;
import com.geovote.services.intf.DistrictService;

@RestController
public class DistrictController {

	@Autowired
	private DistrictService districtService;

	@RequestMapping(value = "/districts", method = RequestMethod.GET)
	public DistrictCollectionRepresentation allDistricts() {
		
				
		List<District> allDistricts = districtService.retrieveAllDistricts();

		return new DistrictCollectionRepresentation(allDistricts);
	}

	@RequestMapping(value = "/district/{code}", method = RequestMethod.GET)
	public District findDistrictByCode(@PathVariable String code) {

		return districtService.findDistrictByCode(code);
	}

}
