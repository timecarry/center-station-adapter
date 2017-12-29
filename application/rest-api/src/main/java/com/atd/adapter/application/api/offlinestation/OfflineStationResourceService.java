package com.atd.adapter.application.api.offlinestation;

import java.util.List;

import com.gakj.core.restful.api.ResourceService;

public interface OfflineStationResourceService extends ResourceService<OfflineStationResource> {

	List<OfflineStationResource> getAll();
}
