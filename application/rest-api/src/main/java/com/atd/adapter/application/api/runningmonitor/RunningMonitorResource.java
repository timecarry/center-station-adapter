package com.atd.adapter.application.api.runningmonitor;

import com.gakj.core.restful.api.BaseResource;

public class RunningMonitorResource extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2340325462076973142L;

	private String jSessionID;

	public String getjSessionID() {
		return jSessionID;
	}

	public void setjSessionID(String jSessionID) {
		this.jSessionID = jSessionID;
	}

}
