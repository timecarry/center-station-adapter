package com.atd.adapter.application.monitor.http;

import com.atd.adapter.domain.station.Station;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class HttpCheckResult {

	private final String message;

	HttpCheckResult(String message) {
		Validate.notNull(message);
		this.message = message;
	}

	boolean isStationOnline(Station station) {
		return message.contains(station.getCode());
	}
}
