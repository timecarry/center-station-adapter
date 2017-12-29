package com.atd.adapter.application.monitor.http;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.atd.adapter.application.monitor.JSessionIDKey;
import com.atd.adapter.application.monitor.Key;
import com.atd.adapter.application.monitor.Monitor;
import com.atd.adapter.application.monitor.MonitorProvider;
import com.atd.adapter.domain.repository.hibernate.HibernateStationImplRepository;
import com.atd.adapter.domain.station.Station;
import com.atd.adapter.domain.station.StationImpl;
import com.atd.adapter.domain.station.StationImplRepository;
import com.gakj.core.transaction.Transaction;
import com.gakj.core.transaction.TransactionManager;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class HttpMonitorProvider implements MonitorProvider {

	private final StationImplRepository stationImplRepository;

	public HttpMonitorProvider() {
		stationImplRepository = new HibernateStationImplRepository();
	}

	@Override
	public Monitor provide(Key key) {
		Validate.isTrue(key instanceof JSessionIDKey, "Invalid Key");
		JSessionIDKey jSessionIDKey = (JSessionIDKey) key;
		TransactionManager transactionManager = TransactionManager.get();
		Transaction beginTransaction = transactionManager.beginTransaction();
		List<StationImpl> all = stationImplRepository.getAll();
		beginTransaction.commit();

		Set<Station> stations = new HashSet<>();
		for (Station station : all) {
			stations.add(station);
		}

		HttpMonitor monitor = new HttpMonitor(stations, jSessionIDKey);
		monitor.start();
		return monitor;
	}

}
