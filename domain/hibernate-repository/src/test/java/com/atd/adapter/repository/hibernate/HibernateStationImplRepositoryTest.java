package com.atd.adapter.repository.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.atd.adapter.domain.repository.hibernate.HibernateStationImplRepository;
import com.atd.adapter.domain.repository.hibernate.HibernateWaterUserImplRepository;
import com.atd.adapter.domain.station.StationImpl;
import com.atd.adapter.domain.station.StationImplRepository;
import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.atd.adapter.domain.wateruser.WaterUserImplRepository;

public class HibernateStationImplRepositoryTest extends BaseRepositoryTest{
	@Test
	public void test() {

		StationImplRepository stationImplRepository=new HibernateStationImplRepository();
		WaterUserImplRepository userImplRepository=new HibernateWaterUserImplRepository();
		String code="001";
		WaterUserImpl waterUser=new WaterUserImpl("any name");
		StationImpl entity=new StationImpl(code, waterUser);
		
		userImplRepository.store(waterUser);
		stationImplRepository.store(entity);
		
		getTransaction().commit();
		beginTransaction();
		
		List<StationImpl> all = stationImplRepository.getAll();
		StationImpl stationImpl = all.get(0);
		
		Assert.assertEquals(1, all.size());
		Assert.assertEquals(entity, stationImpl);
		Assert.assertEquals(entity.getID(), stationImpl.getID());
		Assert.assertEquals(entity.getCode(), stationImpl.getCode());
		Assert.assertEquals(entity.getInstallationLocation(), stationImpl.getInstallationLocation());
		Assert.assertEquals(entity.getCreationDate(), stationImpl.getCreationDate());
		
	}

}
