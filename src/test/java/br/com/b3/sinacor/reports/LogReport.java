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

import br.com.b3.sinacor.commons.Property;
import br.com.b3.sinacor.commons.SetupEnviroment;
import br.com.b3.sinacor.util.Utils;

public class LogReport {
	
	private static ExtentTest extentTest;
	private static ExtentReports extentReport;
	private static ExtentHtmlReporter htmlReporter;
	
	public static ExtentTest getExtentTest() {
		
		return extentTest;
	}
	
	public static void createTest(String cenario) {
		
		if(extentReport == null) {
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(Property.HTML_REPORTER_PATH + Property.HTML_REPORTER_NAME);
			extentReport.attachReporter(htmlReporter);
		}
		
		extentTest = extentReport.createTest(cenario);
	}
	
	public static void logPrint(String strLog) {
		
		String strLogFormatado = Utils.formatarNomeLog(strLog);
		ExtentTest extentTest = LogReport.getExtentTest();
		
		try {
			efetuarPrintTela(strLogFormatado);
			extentTest.log(Status.INFO, strLog, 
					MediaEntityBuilder
					.createScreenCaptureFromPath(
							System.getProperty("user.dir") + Property.HTML_REPORTER_PATH + strLogFormatado + ".png")
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
		assertTrue(true);
	}

	public static void fail(String message) {
		
		ExtentTest extentTest = getExtentTest();
		extentTest.log(Status.FAIL, message);
		assertFalse(message, true);
	}
	
	public static void efetuarPrintTela(String strLog) {
		
		File scrFile = ((TakesScreenshot) SetupEnviroment.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,new File(System.getProperty("user.dir") + Property.HTML_REPORTER_PATH + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
