package com.pages.retails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PagesRetailsDress {
	WebDriver driver;
	public PagesRetailsDress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//*[@class='sf-with-ul'])[4]")
	private WebElement dressTab;
	
//	@FindBy(how = How.XPATH, using  = "//*[@class='product-container']/div[2]/div[1]/span[1]")
//	private WebElement resultset;
//	
//	@FindBy(how = How.XPATH, using  = "(//*[contains(text(),'$30.50')])[2]")
//	private WebElement highestPrice;
//	
	
	
	

//	public WebElement getHighestPrice() {
//		return highestPrice;
//	}
//
//	public void setHighestPrice(WebElement highestPrice) {
//		this.highestPrice = highestPrice;
//	}
//
//	public WebElement getResultset() {
//		return resultset;
//	}
//
//	public void setResultset(WebElement resultset) {
//		this.resultset = resultset;
//	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDressTab() {
		return dressTab;
	}

	public void setDressTab(WebElement dressTab) {
		this.dressTab = dressTab;
	}
	


}
