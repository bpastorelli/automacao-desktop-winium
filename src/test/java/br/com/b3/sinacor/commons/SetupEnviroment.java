package br.com.b3.sinacor.commons;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import br.com.b3.sinacor.reports.LogReport;
import br.com.b3.sinacor.util.Utils;

public class SetupEnviroment {
	
	protected static WiniumDriver driver;
	
	private static DesktopOptions options;
	
	private static WiniumDriverService service;
	
	public WiniumDriver setupEnviroment() throws URISyntaxException {
		
		File applicationPath  = new File(Property.APP_PATH);
		File winiumDriverPath = new File(Utils.getFilePath("driver/" + Property.WINIUM_PATH));
		Integer port = Integer.parseInt(Property.WINIUM_PORT);
		
		options = new DesktopOptions();
		options.setApplicationPath(applicationPath.getAbsolutePath());
		options.setDebugConnectToRunningApp(false);
		options.setLaunchDelay(2);
		
		if(!winiumDriverPath.exists())
			LogReport.fail("O driver no path informado (" + winiumDriverPath + ") nao existe!");
		
		try {
			service = new WiniumDriverService.Builder()
					.usingDriverExecutable(winiumDriverPath)
					.usingPort(port)
					.withVerbose(true)
					.withSilent(false)
					.buildDesktopService();
			service.start();
			driver = new WiniumDriver(service, options);
		} catch (IOException e) {
			System.out.println("Falha ao abrir o driver (" + e.getMessage() +")");
		}
		
		System.out.println("**Driver iniciado com sucesso!");
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
