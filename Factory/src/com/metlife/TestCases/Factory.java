package com.metlife.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.metlife.Pages.*;

public class Factory {
	
	public void factoryErrorResolution() throws InterruptedException{
		
		//System.setProperty ("webdriver.chrome.driver","C:\\Users\\adoma\\Desktop\\Arjun_BackUp\\Selenium\\Selenium_Google_Chrome\\chromedriver.exe" );
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		
		LoginFactoryInstance login = new LoginFactoryInstance(driver, wait);
		login.instanceLogin("mlfactorycd", "adoma", "Varam@009");
		
		FactoryErrors factory = new FactoryErrors(driver, wait);
		factory.navigationToFactoryConversionSetsScreen();
		factory.openConversionSet("000000001A");
		factory.openContract("000000001A");
		
		driver.quit();
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		Factory fact = new Factory();
		fact.factoryErrorResolution();	

	}

}
