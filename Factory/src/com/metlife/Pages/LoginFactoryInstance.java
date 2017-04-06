package com.metlife.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFactoryInstance {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginFactoryInstance(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	//WebElements declaration for Login Page
	
	By userName = By.cssSelector("#username");
	By password = By.cssSelector("#password");
	By logIn = By.xpath(".//*[text()='Log In']");
	By searchTypeDropDown = By.cssSelector("select[id='searchType']");
	
	public void instanceLogin(String url, String uName, String pwd)
			throws InterruptedException{
		driver.get("https://v3.vitechinc.com/"+url+"/app#portal");
		wait.until(ExpectedConditions.visibilityOfElementLocated(logIn));
		Thread.sleep(2000);
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(logIn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTypeDropDown));
		Thread.sleep(2000);
	}

}
