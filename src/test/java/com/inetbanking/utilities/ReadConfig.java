package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		try {
			File file = new File("./Configuration/Config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}

	public String getUserId() {
		String userId = prop.getProperty("userId");
		return userId;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}

	public String getEdgePath() {
		String edgePath = prop.getProperty("edgePath");
		return edgePath;
	}

}
