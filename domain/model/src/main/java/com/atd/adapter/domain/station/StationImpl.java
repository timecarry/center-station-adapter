package com.atd.adapter.domain.station;

import com.atd.adapter.domain.wateruser.WaterUser;
import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.ya.core.domain.BaseEntity;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class StationImpl extends BaseEntity implements Station {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7842706012892326937L;

	private String code;

	private WaterUserImpl waterUser;

	private String installationLocation;
	

	@SuppressWarnings("unused")
	private StationImpl() {
	}

	public StationImpl(String code, WaterUserImpl waterUser) {
		Validate.notNull(code);
		Validate.notNull(waterUser);
		this.code = code;
		this.waterUser = waterUser;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public WaterUser getWaterUser() {
		return waterUser;
	}

	@Override
	public String getInstallationLocation() {
		return installationLocation;
	}



	@Override
	public String toString() {
		return "StationImpl [code=" + code + ", waterUser=" + waterUser + ", InstallationLocation="
				+ installationLocation + "]";
	}

	@Override
	public void setInstallationLocation(String installationLocation) {
		this.installationLocation=installationLocation;
	}




	


	

}
