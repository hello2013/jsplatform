package com.fivelives.net.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtils {
	private Properties properties;

	private String propertiesFile = "";

	PropertiesUtils() {
		if (properties == null) {
			properties = new Properties();
		}
	}

	public PropertiesUtils(String propertiesFile) {
		if (properties == null) {
			properties = new Properties();
		}
		this.propertiesFile = propertiesFile;
		this.readPropertiesFile(propertiesFile);
	}
	
	public Properties getProperties() {
		return properties;
	}

	// 读取资源文件,并处理中文乱码
	public void readPropertiesFile(String filename) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filename);
			properties.clear();
			 InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8"); 
			properties.load(isr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();// 关闭流
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

//	private void readPropertiesFile() {
//		InputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(propertiesFile);
//			properties.load(inputStream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				inputStream.close();// 关闭流
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//		}
//	}
	
	public static void main(String[] args) {
		PropertiesUtils pu = new PropertiesUtils("properties/redis.properties");
		System.out.println(pu.properties.get("username"));
	}
}
