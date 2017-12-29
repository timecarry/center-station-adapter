package com.atd.adapter.application.api.followstation;

import java.util.List;

import com.gakj.core.restful.api.AsyncResourceService;
import com.gakj.core.restful.api.Callback;

public interface AsyncFollowStationResourceService extends AsyncResourceService<FollowStationResource> {

	void add(Callback<com.gakj.core.restful.api.Void> callback, FollowStationResource followStationResource);

	void getAll(Callback<List<FollowStationResource>> callback);

	void remove(Callback<com.gakj.core.restful.api.Void> callback, String id);

	void update(Callback<com.gakj.core.restful.api.Void> callback, FollowStationResource followStationResource);
}
