package com.fivelives.net.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientFactory {
	
	private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(150).build();
	public static CloseableHttpClient getHttpClient(){
		 cm.setDefaultMaxPerRoute(1000); 
		 cm.setMaxTotal(1000);
		 CloseableHttpClient httpclient = HttpClients.custom()
				 .setConnectionManager(cm).setConnectionManagerShared(true)
				 .build();
		 return httpclient;
	}
	
	
	public static  RequestConfig getReqConfig(){
		return requestConfig;
	}
	
}
