package com.atd.adapter.domain.wateruser;

import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface WaterUser extends Entity {

	@Nonnullable
	String getName();
}
