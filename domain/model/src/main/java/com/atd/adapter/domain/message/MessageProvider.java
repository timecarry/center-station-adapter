package com.atd.adapter.domain.message;

import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

public interface MessageProvider {

	@Nonnullable
	Message provide();
}
