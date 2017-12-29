package com.atd.adapter.domain.sensor;

import com.atd.adapter.domain.station.HasStation;
import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface Sensor extends HasStation, Entity {

	@Nonnullable
	String getProviderName();

	@Nonnullable
	String getModeName();

}
