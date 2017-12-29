package com.atd.adapter.application.api.offlinestation;

import com.gakj.core.restful.api.BaseResource;

public class OfflineStationResource extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8991493467928089281L;

	private String code;

	private String waterUserName;

	private String installationLocation;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWaterUserName() {
		return waterUserName;
	}

	public void setWaterUserName(String waterUserName) {
		this.waterUserName = waterUserName;
	}

	public String getInstallationLocation() {
		return installationLocation;
	}

	public void setInstallationLocation(String installationLocation) {
		this.installationLocation = installationLocation;
	}

}
