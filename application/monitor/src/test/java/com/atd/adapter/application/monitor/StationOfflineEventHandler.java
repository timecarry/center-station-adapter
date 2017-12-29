package com.atd.adapter.application.monitor;

import java.util.Set;

import com.atd.adapter.domain.station.Station;
import com.timecarry.pattern.event.Event;
import com.timecarry.pattern.event.typed.TypedEventHandler;

public class StationOfflineEventHandler extends TypedEventHandler {

	public StationOfflineEventHandler() {
		super(StationOfflineEvent.class);
	}

	@Override
	protected void onEventInternal(Event event) {
		StationOfflineEvent stationOfflineEvent = (StationOfflineEvent) event;
		Set<Station> offlineStations = stationOfflineEvent.getOfflineStations();
		OfflineStations.set(offlineStations);
	}

}
