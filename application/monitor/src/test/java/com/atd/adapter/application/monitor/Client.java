package com.atd.adapter.application.monitor;

import org.junit.Test;

import com.atd.adapter.domain.station.Station;
import com.atd.adapter.domain.station.StationImpl;
import com.atd.adapter.domain.wateruser.WaterUserImpl;
import com.atd.adapter.transactional.hibernate.HibernateTransactionManager;
import com.timecarry.pattern.event.RegistrationType;

public class Client {

	@Test
	public void onModuleLoad() throws InterruptedException {
		HibernateTransactionManager.get();
		RegistrationType.Register.send(new StationOfflineEventHandler());
		RegistrationType.Register.send(new MonitorErrorHandler());

		followStation();

		startMonitor();


	}

	private void showboardOfflineStation() throws InterruptedException {
		OfflineStationController offlineStationController = new OfflineStationController();
		while (true) {
			Station[] all = offlineStationController.getAll();
			for (Station offlineStation : all) {
				System.out.println("掉线站点:" + offlineStation);
			}
			Thread.sleep(1000 * 2);
		}
	}

	private void startMonitor() {
		MonitorController controller = new MonitorController();
		String jSessionID = "5540A2CA6F7C9226F09AF8EDF04E6E84";
		controller.start(jSessionID);

	}

	private void followStation() {
		StationFollowController followController = new StationFollowController();
		String code = "5110020001001";
		String name = "取水户1";
		WaterUserImpl waterUser = new WaterUserImpl(name);
		Station station = new StationImpl(code, waterUser);
		followController.follow(station);

		code = "5110020001002";
		name = "取水户2";
		waterUser = new WaterUserImpl(name);
		station = new StationImpl(code, waterUser);
		followController.follow(station);

	}

}
