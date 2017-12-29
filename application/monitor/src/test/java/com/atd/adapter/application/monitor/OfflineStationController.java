package com.atd.adapter.application.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.atd.adapter.domain.station.Station;

public class OfflineStationController {

	public Station[] getAll() {
		Set<Station> set = OfflineStations.get();
		List<Station> list = new ArrayList<>();
		list.addAll(set);
		Station[] stations = new Station[set.size()];
		stations = list.toArray(stations);
		return stations;
	}
}
