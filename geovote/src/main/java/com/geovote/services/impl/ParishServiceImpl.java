package com.geovote.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.geovote.services.intf.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.domain.context.administrative.Parish;
import com.geovote.domain.context.administrative.Voter;
import com.geovote.data.intf.ParishDao;

@Service
@Transactional
public class ParishServiceImpl implements ParishService {

	@Autowired
	ParishDao dao;

	@Override
	public void createNewParish(Parish newParish) {
		dao.create(newParish);
	}

	@Override
	public void deleteExistingDistrict(Parish parishToDelete) {
		dao.delete(parishToDelete);
	}



	@Override
	public List<Voter> findParichesVotersByParishCode(String code) {
		
		return dao.getParishesVotersByParhishCode(code);
	}

	@Override
	public Parish getParishByCode(String code) {
		return dao.getParishByCode(code);

	}

	@Override
	public List<Parish> getAllParishes() {
		return dao.getAllParishes();
	}

}
