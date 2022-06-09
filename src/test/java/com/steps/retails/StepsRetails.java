package com.steps.retails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.retails.PagesRetailsDress;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsRetails {
	WebDriver driver;
	PagesRetailsDress pf;
	ArrayList<String> list;

	@Given("^user go to practice site$")
	public void user_go_to_practice_site() throws Throwable {
//		System.setProperty("webdriver.chrome.driver", "c:\\Driver\\chromedriver.exe");
//		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);///---->
		// Implicit wait
		driver.manage().window().maximize();
		pf = new PagesRetailsDress(driver);

	}

	@When("^user click on the dresses tab$")
	public void user_click_on_the_dresses_tab() throws Throwable {
		// driver.findElement(By.xpath("(//*[@class='sf-with-ul'])[4]")).click();
		pf.getDressTab().click();

	}

	@When("^user capture all dress price from resultset$")
	public void user_capture_all_dress_price_from_resultset() throws Throwable {
		List<WebElement> Price = driver.findElements(By.xpath("//*[@class='product-container']/div[2]/div[1]/span[1]"));
		list = new ArrayList<String>();
		for (int i = 0; i < Price.size(); i++) {
			list.add(Price.get(i).getText());
			System.out.println(Price.get(i).getText());
		}
		System.out.println(list);

//		pf.getResultset();

	}

	@When("^user add to cart the second highest price dress$")
	public void user_add_to_cart_the_second_highest_price_dress() throws Throwable {
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		System.out.println(list.get(1));
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");

		WebElement secDress = driver.findElement(By.xpath("(//*[contains(text(),'$30.50')])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(secDress).perform();

		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[2]/div[2]/a[1]/span")).click();
		WebElement AddCart = driver
				.findElement(By.xpath("//*[@class='right-block']/div[@class='content_price']/span[contains(text(),'"
						+ list.get(1) + "')]//following::div[1]/a[1]"));
		AddCart.click();
		WebElement preChe = driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf(preChe)).click();

	}

	@Then("^user verify total price including shipping user verify the welcome screen$")
	public void user_verify_total_price_including_shipping_user_verify_the_welcome_screen() throws Throwable {
		String totalPrice = driver.findElement(By.xpath("//*[@id='total_price_container']")).getText().trim();
		String capDress = "32.50";

		Assert.assertTrue(totalPrice.equals(capDress));
		System.out.println(totalPrice);
	}
}
