package com.atd.adapter.domain.repository.hibernate;

import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.atd.adapter.domain.wateruser.WaterUserImplRepository;

public class HibernateWaterUserImplRepository extends BaseHibernateEntityRepository<WaterUserImpl> implements WaterUserImplRepository {

	public HibernateWaterUserImplRepository() {
		super(WaterUserImpl.class);
	}
	

}
