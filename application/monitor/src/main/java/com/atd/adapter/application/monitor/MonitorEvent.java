package com.atd.adapter.application.monitor;

import com.timecarry.pattern.event.token.TokenEvent;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface MonitorEvent extends TokenEvent {

	@Nonnullable
	@Override
	Monitor getToken();
}
