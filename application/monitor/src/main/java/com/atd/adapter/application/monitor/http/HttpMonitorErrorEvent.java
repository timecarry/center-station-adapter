package com.atd.adapter.application.monitor.http;

import com.atd.adapter.application.monitor.Monitor;
import com.atd.adapter.application.monitor.MonitorErrorEvent;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class HttpMonitorErrorEvent implements MonitorErrorEvent {

	private final Monitor monitor;

	private final Throwable error;

	public HttpMonitorErrorEvent(HttpMonitor monitor, Throwable error) {
		Validate.notNull(monitor, error);
		this.monitor = monitor;
		this.error = error;
	}

	@Override
	public Monitor getToken() {
		return monitor;
	}

	@Override
	public Throwable getError() {
		return error;
	}

}
