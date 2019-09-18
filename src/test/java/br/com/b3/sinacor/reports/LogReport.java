package br.com.b3.sinacor.reports;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.b3.sinacor.commons.Property;
import br.com.b3.sinacor.commons.SetupEnviroment;
import br.com.b3.sinacor.util.Utils;

public class LogReport {
	
	private static ExtentTest extentTest;
	private static ExtentReports extentReport;
	private static ExtentHtmlReporter htmlReporter;
	private static SetupEnviroment setup = new SetupEnviroment();
	
	public static ExtentTest getExtentTest() {
		
		return extentTest;
	}
	
	public static void createTest(String cenario) {
		
		if(extentReport == null) {
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + Property.HTML_REPORTER_PATH + Property.HTML_REPORTER_NAME);
			extentReport.attachReporter(htmlReporter);
			htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
			htmlReporter.config().setReportName("Name of the Report Comes here");
			htmlReporter.config().setTheme(Theme.STANDARD);
		}
		
		extentTest = extentReport.createTest(cenario);
	}
	
	public static void logPrint(String strLog, Status status) {
		
		ExtentTest extentTest = LogReport.getExtentTest();
		
		try {
			String scrFile = ((TakesScreenshot) setup.getDriver()).getScreenshotAs(OutputType.BASE64);
			extentTest.log(status, strLog, 
					MediaEntityBuilder
					.createScreenCaptureFromBase64String(scrFile)
					.build());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void passFail(Boolean condicao, String message) {
		
		if(condicao)
			pass(message + " - PASSED");
		else 
			fail(message + " - FAIL");
	}
	
	public static void pass(String message) {
		
		ExtentTest extentTest = getExtentTest();
		extentTest.log(Status.PASS, message);
		logPrint(message, Status.PASS);
		assertTrue(true);
	}

	public static void fail(String message) {
		
		ExtentTest extentTest = getExtentTest();
		extentTest.log(Status.FAIL, message);
		logPrint(message, Status.FAIL);
		assertFalse(message, true);
	}
	
	public static void info(String message) {
		
		ExtentTest extentTest = getExtentTest();
		extentTest.log(Status.INFO, message);
		logPrint(message, Status.INFO);
	}
	
	public static String efetuarPrintTela(String strLog) {
		
		String destination = null;
		File scrFile = ((TakesScreenshot) setup.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			String strLogFormatado = Utils.formatarNomeLog(strLog);
			destination = System.getProperty("user.dir") + Property.HTML_REPORTER_PATH + strLogFormatado + ".png";
			FileUtils.copyFile(scrFile, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destination;
	}
	
	public static void finalizarReport() {
		
		extentReport.flush();
	}
}
