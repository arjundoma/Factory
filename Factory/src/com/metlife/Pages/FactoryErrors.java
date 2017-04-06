package com.metlife.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FactoryErrors {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public FactoryErrors(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	// WebElements declaration for Tools>>Factory navigation
	
	By toolsMenu = By.xpath(".//*[text()='Tools']");
	By factoryMenu = By.xpath(".//*[text()='Factory']");
	By conversionSetLinks = By.xpath(".//a[@class='gwt-Anchor v3Hyperlink']");
	
	public void navigationToFactoryConversionSetsScreen() throws InterruptedException {
		driver.findElement(toolsMenu).click();
		Thread.sleep(2000);
		driver.findElement(factoryMenu).click();
		
		for(int x=1;x>0;x++){
			java.util.List<WebElement> E = driver.findElements(conversionSetLinks);			
			if(E.size()>0){
				break;
				}
		}
		Thread.sleep(2000);
		}
	
	// WebElements declaration for opening Conversion Set
	
	By contractField = By.cssSelector("#x-auto-18-input");	
	By annuitantStagingTable = By.xpath(".//*[text()='Annuitant']");
	By unresolvedErrorsColumn = By.xpath(".//*[@id='v3-widget-Factory_FactoryScorecardWidget.ScorecardGrid-v3grid']/div[1]/div/table/tbody[2]/tr/td[6]/div");
	By unresolvedErrorsSorting = By.xpath(".//*[@id='v3-widget-Factory_FactoryScorecardWidget.ScorecardGrid-v3grid']/div[1]/div/table/tbody[2]/tr/td[6]/div/a");
	By sortDescending = By.xpath(".//*[text()='Sort Descending']");
	By tableScoreCardFirstRow = By.xpath(".//*[@id='v3-widget-Factory_FactoryScorecardWidget.ScorecardGrid-v3grid']/div[2]/div[1]/table/tbody[2]/tr[1]/td[6]/div");
	By errorIcon = By.xpath(".//*[@id='v3-widget-ScorecardDataDetailView.DetailGrid-v3grid']/div[2]/div[1]/table/tbody[2]/tr[1]/td[1]/div/div/img");
	By unresolvedErrorsCountScoreCardDetailsWindow = By.xpath(".//*[@id='v3-widget-V_FAC_ERROR_LOG_T.UNRESOLVED_ERRORS_VC-v3integerfield-input']");
	By resolvedErrorsCountScoreCardDetailsWindow = By.xpath(".//*[@id='v3-widget-V_FAC_ERROR_LOG_T.RESOLVED_ERRORS_VC-v3integerfield-input']");
	By unresolvedWarningsCountScoreCardDetailsWindow = By.xpath(".//*[@id='v3-widget-V_FAC_ERROR_LOG_T.UNRESOLVED_WARNINGS_VC-v3integerfield-input']");
	By resolvedWarningsCountScoreCardDetailsWindow = By.xpath(".//*[@id='v3-widget-V_FAC_ERROR_LOG_T.RESOLVED_WARNINGS_VC-v3integerfield-input']");
	By editButtonScoreCardDetails = By.xpath(".//*[@id='v3-widget-v3-widget-Factory_ErrorDetails-v3page-window-edit-button-v3editbutton']/div/div");
	By resolveAllGearIcon = By.xpath(".//*[@id='v3-widget-ScorecardDataDetailView.DetailGrid-v3grid-gridgearaction']");
	By selectAllCheckboxScoreCardDetails = By.xpath(".//*[@id='v3-widget-ScorecardDataDetailView.DetailGrid-v3lockedgrid']/div[1]/div/table/tbody[2]/tr/td/div/span/div");
	By resolveAll = By.xpath(".//*[text()='Resolve All']");
	By clickYesInPopUp = By.xpath(".//*[text()='Yes']");
	
	public void openConversionSet(String contractId) throws InterruptedException{
		driver.findElement(contractField).sendKeys(contractId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		java.util.List<WebElement> E = driver.findElements(conversionSetLinks);
		E.get(0).click();		
		for(int x=1;x>0;x++){
			java.util.List<WebElement> F = driver.findElements(By.xpath(".//*[text()='"+contractId+"']"));		
			if(F.size()>0){
				Thread.sleep(2000);
				break;
				}
		}			
	}
	
	public void openContract(String contractId) throws InterruptedException{
		java.util.List<WebElement> F = driver.findElements(By.xpath(".//*[text()='"+contractId+"']"));
		F.get(0).click();
		for(int y=1;y>0;y++){
			java.util.List<WebElement> G = driver.findElements(annuitantStagingTable);
		    if(G.size()>0){
		    	Thread.sleep(2000);
		    	break;
		    }
			}
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(unresolvedErrorsColumn)).build().perform();
		act.moveToElement(driver.findElement(unresolvedErrorsSorting)).build().perform();
		act.click().perform();
		Thread.sleep(2000);
		driver.findElement(sortDescending).click();
		Thread.sleep(2000);
		String str = driver.findElement(tableScoreCardFirstRow).getText();
		String str2 = str.replace(",", "");
		int unresolvedErrors1 = Integer.parseInt(str2);
		int unresolvedErrors = unresolvedErrors1;		
		for(int x=1;x>0;x++){
			String strErrors = driver.findElement(tableScoreCardFirstRow).getText();
			String strErrors1 = strErrors.replace(",", "");
			int errorCount = Integer.parseInt(strErrors1);
			System.out.println("No of Erros in the Table Score Card First Table row :"+errorCount);
			if(errorCount!=0){
				driver.findElement(tableScoreCardFirstRow).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(errorIcon));
				Thread.sleep(3000);				
				System.out.println("Errors and Warnings Count : ");
				System.out.println("------------------------------");
				System.out.println("Unresolved Errors Count - "+Integer.parseInt(driver.findElement(unresolvedErrorsCountScoreCardDetailsWindow).getAttribute("value")));
				System.out.println("Resolved Errors Count - "+Integer.parseInt(driver.findElement(resolvedErrorsCountScoreCardDetailsWindow).getAttribute("value")));
				System.out.println("Unresolved Warnings Count - "+Integer.parseInt(driver.findElement(unresolvedWarningsCountScoreCardDetailsWindow).getAttribute("value")));
				System.out.println("Resolved Warnings Count - "+Integer.parseInt(driver.findElement(resolvedWarningsCountScoreCardDetailsWindow).getAttribute("value")));
				driver.findElement(editButtonScoreCardDetails).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(resolveAllGearIcon));
				wait.until(ExpectedConditions.elementToBeClickable(selectAllCheckboxScoreCardDetails));
				Thread.sleep(5000);
				driver.findElement(selectAllCheckboxScoreCardDetails).click();
				Thread.sleep(3000);
				driver.findElement(resolveAllGearIcon).click();
				Thread.sleep(2000);
				driver.findElement(resolveAll).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(clickYesInPopUp));
				Thread.sleep(2000);
				driver.findElement(clickYesInPopUp).click();
				Thread.sleep(5000);
				for(int y=1;y>0;y++){
				java.util.List<WebElement> G = driver.findElements(resolvedErrorsCountScoreCardDetailsWindow);
					if(G.size()>0){
					if(Integer.parseInt(G.get(0).getAttribute("value"))==errorCount){
						Thread.sleep(5000);
						java.util.List<WebElement>H = driver.findElements(By.xpath(".//*[contains(@id, 'x-auto-')]/div[2]/table/tbody/tr/td[4]/div"));
						H.get(3).click();
						break;
					}						
					}
					
				}
				
				}else{
					System.out.println("No Errors to Resolve!!!");
					break;
				}
			}
		
		
		
		
		
			
			
				
		
		
		
		
	}
	
	
}
