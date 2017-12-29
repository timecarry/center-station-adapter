package com.atd.adapter.application.monitor;

import java.util.Set;

import com.atd.adapter.domain.station.Station;
import com.timecarry.pattern.event.token.TokenEvent;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface StationOfflineEvent extends TokenEvent {

	@Nonnullable
	Set<Station> getOfflineStations();
}
