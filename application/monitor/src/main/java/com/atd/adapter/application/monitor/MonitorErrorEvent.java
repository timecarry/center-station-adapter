package com.atd.adapter.application.monitor;

public interface MonitorErrorEvent extends MonitorEvent {

	Throwable getError();
}
