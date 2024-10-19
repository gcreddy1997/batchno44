package org.magnitia.selenium.gcreddy.batno44.BaseClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.magnitia.selenium.gcreddy.batno44.Reports.Log;
import org.magnitia.selenium.gcreddy.batno44.Reports.Reports;
import org.magnitia.selenium.gcreddy.batno44.Utilities.ExcelUtils;
import org.magnitia.selenium.gcreddy.batno44.Utilities.Utility;
import org.magnitia.selenium.gcreddy.batno44.constants.Constant;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {

	public static Properties prop_config;
	public static Properties prop_loct;

	
	@BeforeTest
	public void intiliaseFiles() throws IOException, InterruptedException {
		Log.startTESTABC("TestCasename");
		Reports.startTEST("ABC", "description");
		DOMConfigurator.configure("Log4j.xml");		
		ExcelUtils.invokeExcel(Constant.TestData_excel_path);		
		prop_loct = Utility.loadProperty(Constant.locaters_path);
		prop_config = Utility.loadProperty(Constant.config_path);			
		Log.info("All files are invoked successfully");
	}
	
	
	@AfterTest
	public void FLushReports() {
		Reports.flush();
	}

}
