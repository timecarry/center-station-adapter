package com.atd.adapter.application.api.runningmonitor;

import com.gakj.core.restful.api.ResourceService;

public interface RunningMonitorResourceService extends ResourceService<RunningMonitorResource> {

	/**
	 * 启动一个新的监控器
	 * 
	 * @param runningMonitorResource
	 */
	void update(RunningMonitorResource runningMonitorResource);
}
