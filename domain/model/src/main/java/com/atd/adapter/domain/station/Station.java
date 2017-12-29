package com.atd.adapter.domain.station;

import com.atd.adapter.domain.wateruser.WaterUser;
import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;
import com.ya.waterleaks.infrastructure.tooling.mark.Nullable;

public interface Station extends Entity {

	@Nonnullable
	String getCode();

	@Nonnullable
	WaterUser getWaterUser();

	@Nullable
	String getInstallationLocation();
	
	@Nullable
	void setInstallationLocation(String installationLocation);

}
