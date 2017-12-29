package com.atd.adapter.domain.wateruser;

import org.junit.Assert;
import org.junit.Test;

import com.atd.adapter.domain.wateruser.WaterUser;
import com.atd.adapter.domain.wateruser.WaterUserImpl;

public class WaterUserImplTest {

	@Test
	public void test() {
		String name = "any name";
		WaterUser waterUser = new WaterUserImpl(name);

		Assert.assertEquals(name, waterUser.getName());

	}
}
