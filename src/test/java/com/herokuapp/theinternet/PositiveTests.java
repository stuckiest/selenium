package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test // testNG annotation defining this as a test
	public void loginTest() {

		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver nancy = new ChromeDriver();

		sleep(3000);

		nancy.manage().window().maximize();

		// open page
		String url = "https://the-internet.herokuapp.com/login";
		nancy.get(url);

		sleep(5000);
		System.out.println("page is open");

		// enter username
		WebElement username = nancy.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// enter password
		WebElement password = nancy.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// click login button
		WebElement loginButton = nancy.findElement(By.className("radius"));
		loginButton.click();

		// verifications
		// new URL
		String expectedURL = "https://the-internet.herokuapp.com/secure";
		String actualURL = nancy.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);

		// logout button is visible
		WebElement logoutButton = nancy.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		Assert.assertTrue(logoutButton.isDisplayed(), "logoutButton is not displayed");

		// successful login message
		WebElement successMessage = nancy.findElement(By.id("flash"));
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = successMessage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexexpectedSuccessMessage:"
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		sleep(5000);

		// close all windows of browser
		nancy.quit();
		System.out.println("page is closed");
	}

	// driver will pause for specified time in milliseconds - surrounded in
	// try/catch to get rid of eclipse error
	private void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
