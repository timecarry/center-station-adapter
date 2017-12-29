package com.atd.adapter.domain.centerstation;

import org.junit.Assert;
import org.junit.Test;


public class CenterStationImplTest {
	@Test
	public void test() {
		String name="any name";
		String ipAddress="192.168.1.101";
		String hostUrl="www.xxx.com";
		int portNumber=8080;
		
		CenterStation centerStation=new CenterStationImpl(name, ipAddress, hostUrl, portNumber);
		
		Assert.assertEquals(name, centerStation.getName());
		Assert.assertEquals(ipAddress, centerStation.getIPAddress());
		Assert.assertEquals(hostUrl, centerStation.getHostUrl());
		Assert.assertEquals(portNumber, centerStation.getPortNumber());
		
	}

}
