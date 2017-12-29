package com.atd.adapter.application.monitor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.atd.adapter.domain.station.Station;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class StationOfflineEventImpl implements StationOfflineEvent {

	private final Monitor monitor;

	private final Set<Station> stations;

	public StationOfflineEventImpl(Monitor monitor, Set<Station> stations) {
		Validate.notNull(monitor);
		Validate.notNull(stations);

		this.monitor = monitor;
		this.stations = new HashSet<>();
		this.stations.addAll(stations);
	}

	@Override
	public Object getToken() {
		return monitor;
	}

	@Override
	public Set<Station> getOfflineStations() {
		return Collections.unmodifiableSet(stations);
	}

}
