package com.atd.adapter.application.monitor;

import com.ya.waterleaks.infrastructure.tooling.Validate;

public class RunningMonitor {

	private static Monitor running;

	public static void setRunning(Monitor newMonitor) {
		Validate.notNull(newMonitor);
		if (running != null) {
			if (!running.equals(newMonitor)) {
				running.shutdown();
			}
		}
		running = newMonitor;
	}

	public static Monitor get() {
		return running;
	}

	public static void shutdown() {
		if (running != null) {
			running.shutdown();
			running = null;
		}
	}

}
