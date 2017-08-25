package com.geovote.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.data.intf.ConstituencyDao;
import org.springframework.stereotype.Repository;

import com.geovote.domain.context.administrative.Constituency;

@Repository
public class ConstituencyDaoJpaImpl implements ConstituencyDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public void create(Constituency constituency) {

		em.persist(constituency);
	}

	@Override
	public void delete(Constituency constituency) {

		em.remove(constituency);
	}

	@Override
	public List<Constituency> allConstituencies() {

		return em.createQuery("select constituency from Constituency as constituency", Constituency.class)
				.getResultList();

	}

	@Override
	public Constituency getConstituencyByCode(String code) {
		
		return em.createQuery("select constituency from Constituency as constituency where constituency.code =:code", Constituency.class)
				.setParameter("code", code)
				.getSingleResult();
	}

}
