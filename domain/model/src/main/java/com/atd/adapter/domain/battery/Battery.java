package com.atd.adapter.domain.battery;

import com.atd.adapter.domain.station.HasStation;
import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface Battery extends Entity, HasStation {

	@Nonnullable
	BV getBV();
}
