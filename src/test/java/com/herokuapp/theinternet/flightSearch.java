package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class flightSearch {
	

	//TODO: 1. find a way to open incognito window and/or clear cookies
 
	@Parameters({"origin", "destination"})
	@Test
	public void flightSearches(String origin, String destination) {
		System.out.println("Starting Skyscanner Test");
			
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver nancy = new ChromeDriver();
		
		//open page
		String url = "https://www.skyscanner.com/";
		nancy.get(url);
		
		System.out.println("page is open");

		// enter origin
		WebElement originInput = nancy.findElement(By.id("fsc-origin-search"));
		originInput.sendKeys(origin);
		
		sleep(3000);
		
		System.out.println("Using origin: " + origin);
		
		// enter destination
		WebElement destinationInput = nancy.findElement(By.id("fsc-destination-search"));
		destinationInput.sendKeys(destination);
		
		sleep(3000);
		
		System.out.println("Using destination: " + destination);

		// click date picker button
		WebElement openDatePickerButton = nancy.findElement(By.id("depart-fsc-datepicker-button"));
		openDatePickerButton.click();
		
		sleep(3000);
		
		//click the whole month button
		WebElement wholeMonthButton = nancy.findElement(By.xpath("//*[@id='depart-fsc-datepicker-popover']/div/div/div[1]/div/nav/ul/li[2]/button"));
		wholeMonthButton.click();
		
		//click second month on list
		WebElement secondMonth = nancy.findElement(By.xpath("//*[@id=\'depart-fsc-datepicker-popover\']/div/div/div[2]/div/button[3]"));
		secondMonth.click();
		
		sleep(3000);
		
		//click the search flights button
		WebElement searchFlightsButton = nancy.findElement(By.xpath("//*[@id=\'flights-search-controls-root\']/div/div/form/div[3]/button"));
		searchFlightsButton.click();
		
		//keeps breaking here
		sleep(20000);
	
		//verifications
		/*WebElement errorMessageBanner = nancy.findElement(By.id("flash"));
		String actualMessage = errorMessageBanner.getText();
		Assert.assertTrue(actualMessage.contains(expectedErrorMessage),
				"actuaMessage does not contain expectedErrorMessage\nexexpectedErrorMessage:"
						+ expectedErrorMessage + "\nactualSuccessMessage: " + actualMessage); */
		
		sleep(3000);
	
		//close all windows of browser
		nancy.quit();
		System.out.println("The page is closed.");
	}
	
	
	
	private void sleep(long milliseconds) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
