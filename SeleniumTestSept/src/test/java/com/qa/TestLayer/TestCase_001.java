package com.qa.TestLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseLayer.TestBase;
import com.qa.pagelayer.basicControlsPage;
import com.qa.testdata.DataDriventest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_001 extends TestBase {
	
	

	

	@Test(dataProvider="passDataFromExcel", dataProviderClass=DataDriventest.class)
	public void formFill(String FirstName, String LastName, String emailID, String password) {

		basicControlsPage bcp = new basicControlsPage(driver);
		bcp.formRegister(FirstName,LastName,emailID,password);
		log.info("form fill success");
		
	}
	
	@Test
	public void validateLinkTxt() {

		basicControlsPage bcp = new basicControlsPage(driver);
		bcp.clickOnLink();
		
		log.info("link text is working fine");

	}
	
	

}
