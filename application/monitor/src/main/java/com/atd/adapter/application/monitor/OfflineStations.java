package com.atd.adapter.application.monitor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.atd.adapter.domain.station.Station;

public class OfflineStations {

	private static Set<Station> offlines = new HashSet<>();

	public static Set<Station> get() {
		return Collections.unmodifiableSet(offlines);
	}

	public static void set(Set<Station> newOfflines) {
		Set<Station> stations = new HashSet<>();
		stations.addAll(newOfflines);
		offlines = stations;
	}

}
