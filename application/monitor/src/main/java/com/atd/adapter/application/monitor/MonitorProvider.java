package com.atd.adapter.application.monitor;

import com.ya.core.ddd.Factory;

public interface MonitorProvider {

	@Factory(Monitor.class)
	Monitor provide(Key key);
}
