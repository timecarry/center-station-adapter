package com.atd.adapter.application.monitor;

import com.ya.waterleaks.infrastructure.tooling.Validate;
import com.ya.waterleaks.infrastructure.tooling.mark.Nonnullable;

/**
 * JSESSIONID=5540A2CA6F7C9226F09AF8EDF04E6E84
 *
 */
public class JSessionIDKey implements Key {

	private final String value;

	public JSessionIDKey(@Nonnullable String value) {
		Validate.notNull(value);
		this.value = value;
	}

	@Nonnullable
	public String getValue() {
		return value;
	}

}
