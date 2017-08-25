 package com.geovote.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.geovote.services.intf.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.domain.context.administrative.District;
import com.geovote.data.intf.DistrictDao;


@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
	DistrictDao dao;

	@Override
	public void createNewDistrict(District newDistrict) {

		dao.create(newDistrict);		
	}

	@Override
	public void deleteExistingDistrict(District districtToDelete) {

		dao.delete(districtToDelete);
	}

	@Override
	public List<District> retrieveAllDistricts() {

		return dao.allDistricts();
	}

	@Override
	public District findDistrictByCode(String code) {
		
		return dao.getDistrictByCode(code);
	}

}
