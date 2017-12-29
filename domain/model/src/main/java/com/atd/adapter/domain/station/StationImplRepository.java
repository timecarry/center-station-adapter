package com.atd.adapter.domain.station;

import java.util.ArrayList;
import java.util.List;

import com.atd.adapter.domain.wateruser.WaterUser;
import com.ya.core.domain.EntityRepository;

public interface StationImplRepository extends EntityRepository<StationImpl> {
	
	default List<StationImpl> findByWaterUser(WaterUser waterUser) {
		List<StationImpl> result=new ArrayList<>();
		List<StationImpl> all=getAll();
		for (StationImpl stationImpl : all) {
			if (stationImpl.getWaterUser().equals(waterUser)) {
				result.add(stationImpl);
			}
		}
		return result;
	}

}
