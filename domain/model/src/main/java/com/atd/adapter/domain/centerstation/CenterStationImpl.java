package com.atd.adapter.domain.centerstation;

import com.ya.core.domain.BaseEntity;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class CenterStationImpl extends BaseEntity implements CenterStation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3964660785124140060L;

	private String name;

	private String ipAddress;

	private String hostUrl;

	private int portNumber;

	@SuppressWarnings("unused")
	private CenterStationImpl() {
	}

	public CenterStationImpl(String name, String ipAddress, String hostUrl, int portNumber) {
		Validate.notNull(name);
		Validate.notNull(ipAddress);
		Validate.notNull(hostUrl);
		Validate.notNull(portNumber);
		this.name = name;
		this.ipAddress = ipAddress;
		this.hostUrl = hostUrl;
		this.portNumber = portNumber;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getIPAddress() {
		return ipAddress;
	}

	@Override
	public String getHostUrl() {
		return hostUrl;
	}

	@Override
	public int getPortNumber() {
		return portNumber;
	}

	@Override
	public String toString() {
		return "CenterStationImpl [name=" + name + ", ipAddress=" + ipAddress + ", hostUrl=" + hostUrl + ", portNumber="
				+ portNumber + "]";
	}

}
