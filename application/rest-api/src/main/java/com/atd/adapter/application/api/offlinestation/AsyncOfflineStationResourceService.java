package com.atd.adapter.application.api.offlinestation;

import java.util.List;

import com.gakj.core.restful.api.AsyncResourceService;
import com.gakj.core.restful.api.Callback;

public interface AsyncOfflineStationResourceService extends AsyncResourceService<OfflineStationResource> {

	void getAll(Callback<List<OfflineStationResource>> callback);
}
