package com.geovote.data.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.data.intf.VoteDao;
import org.springframework.stereotype.Repository;

import com.geovote.rest.representation.CountRecordRepresentation;

@Repository
public class VoteDaoJpaImpl implements VoteDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CountRecordRepresentation countVotes(String code) {

		return null;
	}



}
