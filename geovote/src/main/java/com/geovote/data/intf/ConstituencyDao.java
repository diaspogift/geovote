package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.administrative.Constituency;

public interface ConstituencyDao {

	public void create(Constituency constituency);

	public void delete(Constituency constituency);

	public List<Constituency> allConstituencies();

	public Constituency getConstituencyByCode(String code);

}
