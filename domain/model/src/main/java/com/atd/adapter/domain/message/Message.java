package com.atd.adapter.domain.message;

import java.util.Date;
import java.util.List;

import com.atd.adapter.domain.battery.BV;
import com.atd.adapter.domain.dtu.SignalStrength;
import com.atd.adapter.domain.sensor.flowmeter.FQ;
import com.atd.adapter.domain.sensor.flowmeter.SQ;
import com.ya.core.ddd.ValueObject;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface Message extends ValueObject {

	@Nonnullable
	Date getCreationTime();

	@Nonnullable
	List<SQ> getSQs();

	@Nonnullable
	List<FQ> getFQs();

	@Nonnullable
	DC getDC();

	@Nonnullable
	BV getBV();

	@Nonnullable
	SignalStrength getSS();
}
