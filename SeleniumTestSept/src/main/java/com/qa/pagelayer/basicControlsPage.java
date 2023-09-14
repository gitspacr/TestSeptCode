package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseLayer.TestBase;

public class basicControlsPage extends TestBase{
	
	WebDriver rdriver;
	
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='femalerb']")
	WebElement rdBtn;
	
	@FindBy(xpath="//input[@id='hindichbx']")
	WebElement chkBox;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTxt;
	
	@FindBy(xpath="//button[@id='clearbtn']")
	WebElement btnClear;
	
	@FindBy(xpath="//a[@id='navigateHome']")
	WebElement linkTxt;
	
	
	public basicControlsPage(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	public void formRegister(String fname, String lname,String emailid, String password) {
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		rdBtn.click();
		chkBox.click();
		emailTxt.sendKeys(emailid);
		passwordTxt.sendKeys(password);
		btnClear.click();
		
		
	}
	
	
	public void clickOnLink() {
		
		linkTxt.click();
		screenshot(driver,"formaFilling");
		
	}
	
	
	
	
	

}
