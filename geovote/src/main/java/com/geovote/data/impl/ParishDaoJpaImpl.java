package com.geovote.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.data.intf.ParishDao;
import org.springframework.stereotype.Repository;

import com.geovote.domain.context.administrative.Parish;
import com.geovote.domain.context.administrative.Voter;

@Repository
public class ParishDaoJpaImpl implements ParishDao {

	
	@PersistenceContext
	EntityManager em;

	@Override
	public void create(Parish parish) {
		
		em.persist(parish);

	}

	@Override
	public void delete(Parish parish) {

		em.remove(parish);
	}

	@Override
	public List<Parish> getAllParishes() {
		
		List<Parish> allParishes = em.createQuery("select parish from Parish as parish", Parish.class).getResultList();

		return allParishes;
	}

	@Override
	public List<Voter> getParishesVotersByParhishCode(String code) {
		
		 	List<Voter> allParishesVoters = em.createQuery("select voter from Voter as voter where voter.parishInfo.parishCode=:code", Voter.class)
												  .setParameter("code", code)
												  .getResultList();
		 	
		 	return allParishesVoters;
		

	}

	@Override
	public Parish getParishByCode(String code) {
		
		Parish parish = em.createQuery("select parish from Parish as parish where parish.code=:code", Parish.class)
									 .setParameter("code", code)
									 .getSingleResult();
		
		return parish;
	}

}
