package com.util;

import java.util.Properties;

public class PropLoader {
	
	static Properties props = new Properties();
	static {
		try {
			props.load(PropLoader.class.getClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String propertyName) {
		return props.getProperty(propertyName);
	}
	
	public static int getint(String propertyName) {
		return Integer.parseInt(props.getProperty(propertyName));
	}

}
