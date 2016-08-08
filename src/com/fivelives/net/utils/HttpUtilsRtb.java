package com.fivelives.net.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;


public class HttpUtilsRtb {
	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException  {
		HttpUtilsRtb.testJson();
	}
	
	public static void testJson() {

		 RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(500).build();//设置请求和传输超时时间
		 
		try {
		HttpPost httpost = new HttpPost("http://ads.zhangfang18.com/jsplatform/spvurl.json");
		CloseableHttpClient httpclient =  HttpClientFactory.getHttpClient();
		httpost.setHeader("Accept", "text/plain");
		httpost.setConfig(requestConfig);
		//设置表单提交编码为UTF-8
		HttpResponse response = httpclient.execute(httpost);
		HttpEntity entity = response.getEntity();
		
		int code = response.getStatusLine().getStatusCode();
		if(200==code){
			InputStream instreams = entity.getContent(); 
			byte[] buf = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (int i; (i = instreams.read(buf)) != -1;) {
				baos.write(buf, 0, i);
				}
				System.err.println("jsonview_en="+baos);
				
		}else{
			System.err.println(code);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {}
	
	}
	
}
