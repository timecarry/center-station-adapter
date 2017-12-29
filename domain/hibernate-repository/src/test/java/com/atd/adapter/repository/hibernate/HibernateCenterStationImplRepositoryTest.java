package com.atd.adapter.repository.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.atd.adapter.domain.centerstation.CenterStationImpl;
import com.atd.adapter.domain.centerstation.CenterStationImplRepository;
import com.atd.adapter.domain.repository.hibernate.HibernateCenterStationImplRepository;

public class HibernateCenterStationImplRepositoryTest extends BaseRepositoryTest {

	@Test
	public void test() {
		CenterStationImplRepository centerStationImplRepository=new HibernateCenterStationImplRepository();
		
		String name="any name";
		String ipAddress="192.168.1.101";
		String hostUrl="www.xxx.com";
		int portNumber=8080;
		CenterStationImpl entity=new CenterStationImpl(name, ipAddress, hostUrl, portNumber);
		centerStationImplRepository.store(entity);
		
		getTransaction().commit();
		beginTransaction();
		
		List<CenterStationImpl> all = centerStationImplRepository.getAll();
		CenterStationImpl centerStationImpl = all.get(0);
		
		Assert.assertEquals(1, all.size());
		Assert.assertEquals(entity, centerStationImpl);
		Assert.assertEquals(entity.getCreationDate(), centerStationImpl.getCreationDate());
		Assert.assertEquals(entity.getName(), centerStationImpl.getName());
		Assert.assertEquals(entity.getIPAddress(), centerStationImpl.getIPAddress());
		Assert.assertEquals(entity.getHostUrl(), centerStationImpl.getHostUrl());
		Assert.assertEquals(entity.getPortNumber(), centerStationImpl.getPortNumber());
	}

}
