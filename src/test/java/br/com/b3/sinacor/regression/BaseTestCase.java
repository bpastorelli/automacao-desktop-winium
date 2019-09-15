package br.com.b3.sinacor.regression;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.winium.WiniumDriver;

import br.com.b3.sinacor.commons.Property;
import br.com.b3.sinacor.commons.SetupEnviroment;
import br.com.b3.sinacor.reports.LogReport;

public class BaseTestCase {
	
	public static WiniumDriver driver;
	public static SetupEnviroment setup = new SetupEnviroment();
	
	@BeforeClass
	public static void beforeClass() throws IOException {
		
		Property.loadProperties();
		setup.setupEnviroment();
		
	}
	
	@AfterClass
	public static void afterClass() {
		
		LogReport.finalizarReport();
		setup.getDriver().close();
	}
}
