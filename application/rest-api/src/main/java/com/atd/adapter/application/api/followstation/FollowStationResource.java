package com.atd.adapter.application.api.followstation;

import com.gakj.core.restful.api.BaseResource;

public class FollowStationResource extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1455136886800970030L;

	private String code;

	private String installationLocation;

	private String waterUserName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInstallationLocation() {
		return installationLocation;
	}

	public void setInstallationLocation(String installationLocation) {
		this.installationLocation = installationLocation;
	}

	public String getWaterUserName() {
		return waterUserName;
	}

	public void setWaterUserName(String waterUserName) {
		this.waterUserName = waterUserName;
	}

}
