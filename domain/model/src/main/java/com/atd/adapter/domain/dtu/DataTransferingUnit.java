package com.atd.adapter.domain.dtu;

import com.atd.adapter.domain.station.HasStation;
import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface DataTransferingUnit extends Entity, HasStation {

	@Nonnullable
	String getPhoneNumber();

	@Nonnullable
	SignalStrength getSignalStrength();
}
