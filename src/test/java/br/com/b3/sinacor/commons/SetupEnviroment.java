package br.com.b3.sinacor.commons;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class SetupEnviroment {
	
	public static WiniumDriver driver;
	public static DesktopOptions options;
	public static WiniumDriverService service;
	
	public WiniumDriver setupEnviroment() {
		
		File applicationPath  = new File(Property.APP_PATH);
		File winiumDriverPath = new File(Property.WINIUM_PATH);
		int port = Integer.parseInt(Property.WINIUM_PORT);
		
		options = new DesktopOptions();
		options.setApplicationPath(applicationPath.getAbsolutePath());
		
		File driverPath = winiumDriverPath.getAbsoluteFile();
		if(!driverPath.exists())
			new Exception("O driver no path informado (" + driverPath + ") não existe!");
			
		try {
			service = new WiniumDriverService.Builder()
					.usingDriverExecutable(driverPath)
					.usingPort(port)
					.withVerbose(true)
					.withSilent(false)
					.buildDesktopService();
			service.start();
			driver = new WiniumDriver(service, options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
	
	public static WiniumDriver getDriver() {
		
		return driver;
	}

}
