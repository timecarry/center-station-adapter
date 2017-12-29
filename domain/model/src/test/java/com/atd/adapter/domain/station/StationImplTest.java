package com.atd.adapter.domain.station;

import org.junit.Assert;
import org.junit.Test;

import com.atd.adapter.domain.wateruser.WaterUserImpl;

public class StationImplTest {
	@Test
	public void test() {

		String code = "001";
		WaterUserImpl waterUser = new WaterUserImpl("any name");
		Station station = new StationImpl(code, waterUser);
		
		Assert.assertNull(station.getInstallationLocation());
		
		station.setInstallationLocation("取水路1号");

		Assert.assertEquals("取水路1号", station.getInstallationLocation());
	}

}
