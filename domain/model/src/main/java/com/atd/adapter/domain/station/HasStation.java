package com.atd.adapter.domain.station;

import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface HasStation {

	@Nonnullable
	Station getStation();
}
