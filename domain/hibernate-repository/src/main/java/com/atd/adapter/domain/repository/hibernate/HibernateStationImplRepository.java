package com.atd.adapter.domain.repository.hibernate;

import com.atd.adapter.domain.station.StationImpl;
import com.atd.adapter.domain.station.StationImplRepository;

public class HibernateStationImplRepository extends BaseHibernateEntityRepository<StationImpl> implements StationImplRepository{

	public HibernateStationImplRepository() {
		super(StationImpl.class);
	}

}
