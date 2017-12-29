package com.atd.adapter.domain.centerstation;

import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface CenterStation extends Entity {

	@Nonnullable
	String getName();

	@Nonnullable
	String getIPAddress();

	@Nonnullable
	String getHostUrl();

	@Nonnullable
	int getPortNumber();
}
