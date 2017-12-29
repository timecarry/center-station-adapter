package com.atd.adapter.application.monitor;

import com.atd.adapter.domain.repository.hibernate.HibernateStationImplRepository;
import com.atd.adapter.domain.repository.hibernate.HibernateWaterUserImplRepository;
import com.atd.adapter.domain.station.Station;
import com.atd.adapter.domain.station.StationImpl;
import com.atd.adapter.domain.station.StationImplRepository;
import com.atd.adapter.domain.wateruser.WaterUser;
import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.atd.adapter.domain.wateruser.WaterUserImplRepository;
import com.gakj.core.transaction.Transaction;
import com.gakj.core.transaction.TransactionManager;

public class StationFollowController {

	private StationImplRepository stationImplRepository = new HibernateStationImplRepository();
	private WaterUserImplRepository waterUserImplRepository = new HibernateWaterUserImplRepository();
	
	public void follow(Station station) {
		StationImpl stationImpl = (StationImpl) station;
		Transaction beginTransaction = TransactionManager.get().beginTransaction();
		WaterUser waterUser = stationImpl.getWaterUser();
		waterUserImplRepository.store((WaterUserImpl) waterUser);
		stationImplRepository.store((StationImpl) station);
		beginTransaction.commit();
	}

}
