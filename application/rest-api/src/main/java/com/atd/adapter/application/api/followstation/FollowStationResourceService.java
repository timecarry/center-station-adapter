package com.atd.adapter.application.api.followstation;

import java.util.List;

import com.gakj.core.restful.api.ResourceService;

public interface FollowStationResourceService extends ResourceService<FollowStationResource> {

	void add(FollowStationResource followStationResource);

	List<FollowStationResource> getAll();

	void remove(String id);

	void update(FollowStationResource followStationResource);
}
