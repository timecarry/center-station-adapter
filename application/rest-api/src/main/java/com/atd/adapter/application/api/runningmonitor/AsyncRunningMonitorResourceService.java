package com.atd.adapter.application.api.runningmonitor;

import com.gakj.core.restful.api.AsyncResourceService;
import com.gakj.core.restful.api.Callback;
import com.gakj.core.restful.api.Void;

public interface AsyncRunningMonitorResourceService extends AsyncResourceService<RunningMonitorResource> {

	void update(RunningMonitorResource monitorResource, Callback<Void> callback);
}
