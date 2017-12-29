package com.atd.adapter.application.monitor;

import org.junit.Test;

import com.atd.adapter.application.monitor.http.HttpMonitorProvider;
import com.atd.adapter.domain.repository.hibernate.HibernateStationImplRepository;
import com.atd.adapter.domain.repository.hibernate.HibernateWaterUserImplRepository;
import com.atd.adapter.domain.station.StationImpl;
import com.atd.adapter.domain.station.StationImplRepository;
import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.atd.adapter.domain.wateruser.WaterUserImplRepository;
import com.atd.adapter.transactional.hibernate.HibernateTransactionManager;
import com.gakj.core.transaction.Transaction;
import com.gakj.core.transaction.TransactionManager;
import com.timecarry.pattern.event.RegistrationType;

public class MonitorTest {

	@Test
	public void test() throws InterruptedException {
		TransactionManager transactionManager = HibernateTransactionManager.get();
		Transaction beginTransaction = transactionManager.beginTransaction();
		WaterUserImplRepository waterUserImplRepository = new HibernateWaterUserImplRepository();
		StationImplRepository stationImplRepository = new HibernateStationImplRepository();
		WaterUserImpl waterUser = new WaterUserImpl("any name");
		waterUserImplRepository.store(waterUser);

		StationImpl stationImpl = new StationImpl("123", waterUser);
		stationImplRepository.store(stationImpl);
		beginTransaction.commit();

		StationOfflineEventHandler stationOfflineEventHandler = new StationOfflineEventHandler();
		RegistrationType.Register.send(stationOfflineEventHandler);

		MonitorProvider provider = new HttpMonitorProvider();
		String value = "5540A2CA6F7C9226F09AF8EDF04E6E84";
		Key key = new JSessionIDKey(value);

	}

}
