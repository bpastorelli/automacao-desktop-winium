package br.com.b3.sinacor.commons;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import br.com.b3.sinacor.reports.LogReport;

public class SetupEnviroment {
	
	protected static WiniumDriver driver;
	
	private static DesktopOptions options;
	
	private static WiniumDriverService service;
	
	public WiniumDriver setupEnviroment() {
		
		File applicationPath  = new File(Property.APP_PATH);
		File winiumDriverPath = new File(Property.WINIUM_PATH);
		Integer port = Integer.parseInt(Property.WINIUM_PORT);
		
		options = new DesktopOptions();
		options.setApplicationPath(applicationPath.getAbsolutePath());
		options.setDebugConnectToRunningApp(false);
		options.setLaunchDelay(2);
		
		File driverPath = winiumDriverPath.getAbsoluteFile();
		if(!driverPath.exists())
			LogReport.fail("O driver no path informado (" + driverPath + ") nao existe!");
		
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
	
	public WiniumDriver getDriver() {
		
		return driver;
	}
	
	public void driverClose() {
		
		try {
			driver.close();
		}catch(Exception e) {
			try {
				Runtime.getRuntime().exec("TASKKILL /F /IM calculator.exe");
			} catch (IOException e1) {
				System.out.println("[FALHA]Falha ao fechar o driver [" + e.getMessage() + "]");
			}
		}
	}	
	
	public void serviceStop() {
		
		service.stop();
	}	
}
