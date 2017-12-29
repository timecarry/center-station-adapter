package com.atd.adapter.application.monitor;

import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface MonitorOfflineEvent extends MonitorEvent {

	@Nonnullable
	default Monitor getOfflineMonitor() {
		return getToken();
	}
}
