package com.atd.adapter.application.monitor.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseReader {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseReader.class);

	public static String responseToString(CloseableHttpResponse response) throws IOException {
		StringBuffer sb = new StringBuffer();
		try {
			HttpEntity entity1 = response.getEntity();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity1.getContent()));
			Stream<String> lines = bufferedReader.lines();
			Object[] array = lines.toArray();
			for (Object object : array) {
				sb.append(object.toString());
			}

			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity1);

		} finally {
			response.close();
		}
		String responseAsString = sb.toString();
		LOGGER.debug("http response:" + responseAsString);
		return responseAsString;
	}
}
