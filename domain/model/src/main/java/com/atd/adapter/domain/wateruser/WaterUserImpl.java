package com.atd.adapter.domain.wateruser;

import com.ya.core.domain.BaseEntity;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class WaterUserImpl extends BaseEntity implements WaterUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6383420300054341862L;

	private String name;
	
	@SuppressWarnings("unused")
	private WaterUserImpl(){
		
	}

	public WaterUserImpl(String name) {
		Validate.notNull(name);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "WaterUserImpl [name=" + name + "]";
	}

}
