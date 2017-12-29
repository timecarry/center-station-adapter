package com.atd.adapter.application.monitor;

import com.atd.adapter.application.monitor.http.HttpMonitorProvider;

public class MonitorController {
	
	private final MonitorProvider provider = new HttpMonitorProvider();

	public void start(String jSessionID) {
		Key key = new JSessionIDKey(jSessionID);
		Monitor monitor = provider.provide(key);
		RunningMonitor.setRunning(monitor);
	}

}
