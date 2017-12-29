package com.atd.adapter.application.monitor.http;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;

import com.atd.adapter.application.monitor.JSessionIDKey;
import com.atd.adapter.application.monitor.Monitor;
import com.atd.adapter.application.monitor.MonitorErrorEvent;
import com.atd.adapter.application.monitor.StationOfflineEvent;
import com.atd.adapter.application.monitor.StationOfflineEventImpl;
import com.atd.adapter.domain.station.Station;
import com.timecarry.pattern.event.GlobalEventHandler;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class HttpMonitor implements Monitor {

	private final Set<Station> stations;

	private Timer timer;

	private final HttpChecker checker;

	private final JSessionIDKey jSessionIDKey;

	public HttpMonitor(Set<Station> stations, JSessionIDKey jSessionIDKey) {
		Validate.notNull(jSessionIDKey);
		this.stations = new HashSet<>();
		this.stations.addAll(stations);
		timer = new Timer();
		checker = new HttpChecker();
		this.jSessionIDKey = jSessionIDKey;
	}

	@Override
	public boolean isOnline() {
		return timer != null;
	}

	public void start() {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				check();
			}
		}, new Date(), 1000 * 60 * 5);

	}

	private void check() {
		try {
			Set<Station> offlineStations = new HashSet<>();
			// 从中心服务器取在线站点数据
			HttpCheckResult check = checker.check(jSessionIDKey.getValue());
			
			// 根据关注站点检查该关注站点是否在线
			for (Station station : stations) {
				if (!check.isStationOnline(station)) {
					offlineStations.add(station);
				}
			}

			// 判断是否存在掉线站点
			if (offlineStations.size() != 0) {
				// 准备站点掉线事件
				StationOfflineEvent stationOfflineEvent = new StationOfflineEventImpl(this, offlineStations);
				// 发布站点掉线事件
				GlobalEventHandler.onEvent(stationOfflineEvent);
			}

		} catch (ClientProtocolException e) {
			MonitorErrorEvent errorEvent = new HttpMonitorErrorEvent(this, e);
			GlobalEventHandler.onEvent(errorEvent);
		} catch (IOException e) {
			MonitorErrorEvent errorEvent = new HttpMonitorErrorEvent(this, e);
			GlobalEventHandler.onEvent(errorEvent);
		}
	}

	@Override
	public void shutdown() {
		timer.cancel();
		timer = null;
	}

}
