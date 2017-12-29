package com.atd.adapter.domain.wateruser;

import java.util.ArrayList;
import java.util.List;

import com.ya.core.domain.EntityRepository;

public interface WaterUserImplRepository extends EntityRepository<WaterUserImpl> {

	default List<WaterUserImpl> findByName(String name) {
		List<WaterUserImpl> result = new ArrayList<>();
		List<WaterUserImpl> all = getAll();
		for (WaterUserImpl waterUserImpl : all) {
			if (waterUserImpl.getName().equals(name)) {
				result.add(waterUserImpl);
			}
		}
		return result;
	}
}
