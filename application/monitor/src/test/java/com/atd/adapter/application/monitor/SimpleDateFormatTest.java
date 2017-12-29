package com.atd.adapter.application.monitor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class SimpleDateFormatTest {

	@Test
	public void test() {
		Calendar from = Calendar.getInstance();
		from.set(Calendar.MINUTE, 0);
		from.set(Calendar.SECOND, 0);
		from.add(Calendar.MINUTE, -30);
		Calendar to = Calendar.getInstance();
		to.set(Calendar.MINUTE, 0);
		to.set(Calendar.SECOND, 0);
		String rnd = String.valueOf(new Random().nextDouble());

		CloseableHttpClient httpclient = HttpClients.createDefault();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Chongqing"));

		String uri = "http://www.scszyjs.com/newApp/RMST/Query/RealQ/GetJC_DATA.srdbselect?bgtm=" + sdf.format(from.getTime()).replace(" ".toCharArray()[0], "＋".toCharArray()[0]) + "&edtm="
				+ sdf.format(to.getTime()).replace(" ".toCharArray()[0], "＋".toCharArray()[0]) + "&AD_CD=SUBSTR(WIUST_CD,1,4)=SUBSTR('511000',1,4)&rnd=" + rnd;

		System.out.println(uri);
	}

}
