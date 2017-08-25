package com.geovote.controllers.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.context.administrative.Constituency;
import com.geovote.rest.representation.ConstituencyCollectionRepresentation;
import com.geovote.services.intf.ConstituencyService;

@RestController
public class ConstituencyController {

	@Autowired
	private ConstituencyService constituencyService;

	@RequestMapping(value = "/constituencies", method = RequestMethod.GET)
	public ConstituencyCollectionRepresentation allConstituencies() {

		List<Constituency> allConstituencies = constituencyService.retrieveAllConstituencies();

		return new ConstituencyCollectionRepresentation(allConstituencies);
	}

	@RequestMapping(value = "/constituency/{code}", method = RequestMethod.GET)
	public Constituency findConstituencyByCode(@PathVariable String code) {

		return constituencyService.findConstituencyByCode(code);
	}

}
