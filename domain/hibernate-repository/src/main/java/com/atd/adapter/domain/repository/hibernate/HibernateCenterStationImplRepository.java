package com.atd.adapter.domain.repository.hibernate;

import com.atd.adapter.domain.centerstation.CenterStationImpl;
import com.atd.adapter.domain.centerstation.CenterStationImplRepository;

public class HibernateCenterStationImplRepository extends BaseHibernateEntityRepository<CenterStationImpl>implements CenterStationImplRepository{

	public HibernateCenterStationImplRepository() {
		super(CenterStationImpl.class);
	}

}
