package com.atd.adapter.repository.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.atd.adapter.domain.repository.hibernate.HibernateWaterUserImplRepository;
import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.atd.adapter.domain.wateruser.WaterUserImplRepository;

public class HibernateWaterUserImplRepositoryTest extends BaseRepositoryTest {

	@Test
	public void test() {
		WaterUserImplRepository waterUserImplRepository = new HibernateWaterUserImplRepository();

		String name = "any name";
		WaterUserImpl entity = new WaterUserImpl(name);
		waterUserImplRepository.store(entity);
		
		getTransaction().commit();
		beginTransaction();

		List<WaterUserImpl> findByName = waterUserImplRepository.findByName(name);
		Assert.assertEquals(1, findByName.size());
		WaterUserImpl waterUserImpl = findByName.get(0);
		Assert.assertEquals(entity, waterUserImpl);
		Assert.assertEquals(entity.getCreationDate(), waterUserImpl.getCreationDate());
		Assert.assertEquals(entity.getName(), waterUserImpl.getName());
	}

}
