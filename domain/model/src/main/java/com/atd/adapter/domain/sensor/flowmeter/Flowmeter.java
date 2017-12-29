package com.atd.adapter.domain.sensor.flowmeter;

import com.atd.adapter.domain.sensor.Sensor;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface Flowmeter extends Sensor {

	@Nonnullable
	FQ getFQ();

	@Nonnullable
	SQ getSQ();

	@Nonnullable
	String getCode();
}
