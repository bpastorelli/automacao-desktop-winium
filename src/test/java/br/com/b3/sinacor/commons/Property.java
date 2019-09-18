package br.com.b3.sinacor.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Property {
	
	public static String APP_PATH;
	public static String WINIUM_PATH;
	public static String WINIUM_PORT;
	public static String HTML_REPORTER_NAME;
	public static String HTML_REPORTER_PATH;
	
	private static final String PROP_FILE_CONFIG = "src/test/resources/config.properties";
	
	private static Properties getProp() throws IOException {
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(PROP_FILE_CONFIG);
		props.load(file);
		return props;
	}
	
	public static void loadProperties(){
		
		try {
			Properties properties = getProp();
			APP_PATH           = properties.getProperty("application.path");
			WINIUM_PATH        = properties.getProperty("winiumDriver.path");
			WINIUM_PORT        = properties.getProperty("winiumDriver.port");
			HTML_REPORTER_NAME = properties.getProperty("extent.report.name");
			HTML_REPORTER_PATH = properties.getProperty("extent.report.path");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
