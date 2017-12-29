package com.atd.adapter.application.monitor;

import com.timecarry.pattern.event.Event;
import com.timecarry.pattern.event.typed.TypedEventHandler;

public class MonitorErrorHandler extends TypedEventHandler {

	public MonitorErrorHandler() {
		super(MonitorErrorEvent.class);
	}

	@Override
	protected void onEventInternal(Event event) {
		MonitorErrorEvent monitorErrorEvent = (MonitorErrorEvent) event;
		System.out.println("Monitor error:");
		System.out.println(monitorErrorEvent.getToken());
		monitorErrorEvent.getError().printStackTrace();
	}

}
