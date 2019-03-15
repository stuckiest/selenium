package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test(priority =1, enabled = true, groups = { "SmokeTests", "negativeTests"})
	public void incorrectUsernameTest() {
	
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver nancy = new ChromeDriver();
		
		//open page
		String url = "https://the-internet.herokuapp.com/login";
		nancy.get(url);
		
		sleep(3000);
		System.out.println("page is open");

		// enter incorrect username
		WebElement username = nancy.findElement(By.id("username"));
		username.sendKeys("bubbasmith");
		
		// enter correct password
		WebElement password = nancy.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// click login button
		WebElement loginButton = nancy.findElement(By.className("radius"));
		loginButton.click();
	
		//verifications
		//warning message is visible
		WebElement errorMessage = nancy.findElement(By.id("flash"));
		String expectedErrorMessage = "Your username is invalid!";
		String actualMessage = errorMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedErrorMessage),
				"actuaMessage does not contain expectedErrorMessage\nexexpectedErrorMessage:"
						+ expectedErrorMessage + "\nactualSuccessMessage: " + actualMessage);
		
		//URL does not change
		String expectedURL = "https://the-internet.herokuapp.com/login";
		String actualURL = nancy.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
		sleep(3000);
	
		//close all windows of browser
		nancy.quit();
		System.out.println("The page is closed.");
	}
	
	@Test(priority = 2, groups = {"negativeTests"})
	public void incorrectPasswordTest() {
	
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver nancy = new ChromeDriver();
		
		//open page
		String url = "https://the-internet.herokuapp.com/login";
		nancy.get(url);
		
		sleep(3000);
		System.out.println("page is open");

		// enter correct username
		WebElement username = nancy.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		// enter incorrect password
		WebElement password = nancy.findElement(By.id("password"));
		password.sendKeys("IncorrectPassword");

		// click login button
		WebElement loginButton = nancy.findElement(By.className("radius"));
		loginButton.click();
	
		//verifications
		//warning message is visible
		WebElement errorMessage = nancy.findElement(By.id("flash"));
		String expectedErrorMessage = "Your password is invalid!";
		String actualMessage = errorMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedErrorMessage),
				"actuaMessage does not contain expectedErrorMessage\nexexpectedErrorMessage:"
						+ expectedErrorMessage + "\nactualSuccessMessage: " + actualMessage);
		
		//URL does not change
		String expectedURL = "https://the-internet.herokuapp.com/login";
		String actualURL = nancy.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
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
