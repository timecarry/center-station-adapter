package com.atd.adapter.domain.sensor.flowmeter;

import java.util.ArrayList;
import java.util.List;

import com.atd.adapter.domain.station.Station;
import com.ya.core.domain.EntityRepository;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public interface FlowmeterRepository extends EntityRepository<Flowmeter> {

	default List<Flowmeter> findByStation(Station station) {
		Validate.notNull(station);
		List<Flowmeter> result = new ArrayList<>();
		List<Flowmeter> all = getAll();
		for (Flowmeter flowmeter : all) {
			if (flowmeter.getStation().equals(station)) {
				result.add(flowmeter);
			}
		}
		return result;
	}
}
